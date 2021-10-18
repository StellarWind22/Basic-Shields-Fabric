package com.github.crimsondawn45.vanillaplusshields.mixin;

import com.github.crimsondawn45.fabricshieldlib.initializers.FabricShieldLib;
import com.github.crimsondawn45.vanillaplusshields.VanillaPlusShields;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BuiltinModelItemRenderer.class)
public class RendererMixin {

	//Wood
	private ShieldEntityModel woodShieldModel;
	private static final SpriteIdentifier WOOD_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(VanillaPlusShields.MOD_ID,"entity/wood_shield_base"));
	private static final SpriteIdentifier WOOD_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(VanillaPlusShields.MOD_ID,"entity/wood_shield_base_nopattern"));

	//Gold
	private ShieldEntityModel goldShieldModel;
	private static final SpriteIdentifier GOLD_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(VanillaPlusShields.MOD_ID,"entity/gold_shield_base"));
	private static final SpriteIdentifier GOLD_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(VanillaPlusShields.MOD_ID,"entity/gold_shield_base_nopattern"));

	//Diamond
	private ShieldEntityModel diamondShieldModel;
	private static final SpriteIdentifier DIAMOND_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(VanillaPlusShields.MOD_ID,"entity/diamond_shield_base"));
	private static final SpriteIdentifier DIAMOND_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(VanillaPlusShields.MOD_ID,"entity/diamond_shield_base_nopattern"));

	//Netherrite
	private ShieldEntityModel netherriteShieldModel;
	private static final SpriteIdentifier NETHERRITE_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(VanillaPlusShields.MOD_ID,"entity/netherrite_shield_base"));
	private static final SpriteIdentifier NETHERRITE_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(VanillaPlusShields.MOD_ID,"entity/netherrite_shield_base_nopattern"));

	@Final
	@Shadow
	private EntityModelLoader entityModelLoader;


	@Inject(method = "reload", at = @At("HEAD"))
	private void setModels(CallbackInfo ci){

		//Wood
		woodShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(VanillaPlusShields.wood_shield_model_layer));

		//Gold
		goldShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(VanillaPlusShields.gold_shield_model_layer));

		//Diamond
		diamondShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(VanillaPlusShields.diamond_shield_model_layer));

		//Netherrite
		netherriteShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(VanillaPlusShields.netherrite_shield_model_layer));
	}

	@Inject(method = "render", at = @At("HEAD"))
	private void mainRender(ItemStack stack, ModelTransformation.Mode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, CallbackInfo ci) {

		//Wood
		if (stack.isOf(VanillaPlusShields.wood_shield)) {
			FabricShieldLib.renderBanner(stack, matrices, vertexConsumers, light, overlay, woodShieldModel, WOOD_SHIELD_BASE, WOOD_SHIELD_BASE_NO_PATTERN);
		}

		//Gold
		if (stack.isOf(VanillaPlusShields.gold_shield)) {
			FabricShieldLib.renderBanner(stack, matrices, vertexConsumers, light, overlay, goldShieldModel, GOLD_SHIELD_BASE, GOLD_SHIELD_BASE_NO_PATTERN);
		}

		//Diamond
		if (stack.isOf(VanillaPlusShields.diamond_shield)) {
			FabricShieldLib.renderBanner(stack, matrices, vertexConsumers, light, overlay, diamondShieldModel, DIAMOND_SHIELD_BASE, DIAMOND_SHIELD_BASE_NO_PATTERN);
		}

		//Netherrite
		if (stack.isOf(VanillaPlusShields.netherrite_shield)) {
			FabricShieldLib.renderBanner(stack, matrices, vertexConsumers, light, overlay, netherriteShieldModel, NETHERRITE_SHIELD_BASE, NETHERRITE_SHIELD_BASE_NO_PATTERN);
		}
	}
}