package com.github.crimsondawn45.basicshields.mixin;

import com.github.crimsondawn45.basicshields.util.ContentModule;
import com.github.crimsondawn45.basicshields.util.ModShieldItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;

@Mixin(BuiltinModelItemRenderer.class)
public class RendererMixin {

	@Final
	@Shadow
	private EntityModelLoader entityModelLoader;

	@Inject(method = "reload", at = @At("HEAD"))
	private void setModels(CallbackInfo ci){

		/**
		 * Set the models
		 */
		for(ContentModule module : ContentModule.loadedModules) {

			for(ModShieldItem shield : module.getShieldItems()) {

				shield.setShieldEntityModel(entityModelLoader);
			}
		}
	}

	@Inject(method = "render", at = @At("HEAD"))
	private void mainRender(ItemStack stack, ModelTransformation.Mode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, CallbackInfo ci) {

		/**
		 * Handle rendering the shields
		 */
		for(ContentModule module : ContentModule.loadedModules) {

			for(ModShieldItem shield : module.getShieldItems()) {
				
				//Allows each shied to control it's own rendering
				shield.renderBanner(stack, matrices, vertexConsumers, light, overlay);
			}
		}
	}
}