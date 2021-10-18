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

	//Wooden
	private ShieldEntityModel woodenShieldModel;
	private static final SpriteIdentifier WOODEN_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(VanillaPlusShields.MOD_ID,"entity/wooden_shield_base"));
	private static final SpriteIdentifier WOODEN_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(VanillaPlusShields.MOD_ID,"entity/wooden_shield_base_nopattern"));

	//Golden
	private ShieldEntityModel goldenShieldModel;
	private static final SpriteIdentifier GOLDEN_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(VanillaPlusShields.MOD_ID,"entity/golden_shield_base"));
	private static final SpriteIdentifier GOLDEN_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(VanillaPlusShields.MOD_ID,"entity/golden_shield_base_nopattern"));

	//Diamond
	private ShieldEntityModel diamondShieldModel;
	private static final SpriteIdentifier DIAMOND_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(VanillaPlusShields.MOD_ID,"entity/diamond_shield_base"));
	private static final SpriteIdentifier DIAMOND_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(VanillaPlusShields.MOD_ID,"entity/diamond_shield_base_nopattern"));

	//Netherite
	private ShieldEntityModel netheriteShieldModel;
	private static final SpriteIdentifier NETHERITE_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(VanillaPlusShields.MOD_ID,"entity/netherite_shield_base"));
	private static final SpriteIdentifier NETHERITE_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(VanillaPlusShields.MOD_ID,"entity/netherite_shield_base_nopattern"));

	@Final
	@Shadow
	private EntityModelLoader entityModelLoader;


	@Inject(method = "reload", at = @At("HEAD"))
	private void setModels(CallbackInfo ci){

		//Wooden
		woodenShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(VanillaPlusShields.wooden_shield_model_layer));

		//Golden
		goldenShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(VanillaPlusShields.golden_shield_model_layer));

		//Diamond
		diamondShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(VanillaPlusShields.diamond_shield_model_layer));

		//Netherite
		netheriteShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(VanillaPlusShields.netherite_shield_model_layer));
	}

	@Inject(method = "render", at = @At("HEAD"))
	private void mainRender(ItemStack stack, ModelTransformation.Mode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, CallbackInfo ci) {

		//Wooden
		if (stack.isOf(VanillaPlusShields.wooden_shield)) {
			FabricShieldLib.renderBanner(stack, matrices, vertexConsumers, light, overlay, woodenShieldModel, WOODEN_SHIELD_BASE, WOODEN_SHIELD_BASE_NO_PATTERN);
		}

		//Golden
		if (stack.isOf(VanillaPlusShields.golden_shield)) {
			FabricShieldLib.renderBanner(stack, matrices, vertexConsumers, light, overlay, goldenShieldModel, GOLDEN_SHIELD_BASE, GOLDEN_SHIELD_BASE_NO_PATTERN);
		}

		//Diamond
		if (stack.isOf(VanillaPlusShields.diamond_shield)) {
			FabricShieldLib.renderBanner(stack, matrices, vertexConsumers, light, overlay, diamondShieldModel, DIAMOND_SHIELD_BASE, DIAMOND_SHIELD_BASE_NO_PATTERN);
		}

		//Netherite
		if (stack.isOf(VanillaPlusShields.netherite_shield)) {
			FabricShieldLib.renderBanner(stack, matrices, vertexConsumers, light, overlay, netheriteShieldModel, NETHERITE_SHIELD_BASE, NETHERITE_SHIELD_BASE_NO_PATTERN);
		}
	}
}