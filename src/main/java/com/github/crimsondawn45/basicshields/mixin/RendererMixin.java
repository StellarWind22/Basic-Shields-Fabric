package com.github.crimsondawn45.basicshields.mixin;

import com.github.crimsondawn45.basicshields.BasicShields;
import com.github.crimsondawn45.basicshields.BasicShieldsClient;
import com.github.crimsondawn45.basicshields.registry.ModItems;
import com.github.crimsondawn45.fabricshieldlib.initializers.FabricShieldLibClient;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.fabricmc.loader.api.FabricLoader;
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

@Mixin(BuiltinModelItemRenderer.class)
public class RendererMixin {

	//Wooden
	private ShieldEntityModel woodenShieldModel;
	private static final SpriteIdentifier WOODEN_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/wooden_shield_base"));
	private static final SpriteIdentifier WOODEN_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/wooden_shield_base_nopattern"));

	//Golden
	private ShieldEntityModel goldenShieldModel;
	private static final SpriteIdentifier GOLDEN_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/golden_shield_base"));
	private static final SpriteIdentifier GOLDEN_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/golden_shield_base_nopattern"));

	//Diamond
	private ShieldEntityModel diamondShieldModel;
	private static final SpriteIdentifier DIAMOND_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/diamond_shield_base"));
	private static final SpriteIdentifier DIAMOND_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/diamond_shield_base_nopattern"));

	//Netherite
	private ShieldEntityModel netheriteShieldModel;
	private static final SpriteIdentifier NETHERITE_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/netherite_shield_base"));
	private static final SpriteIdentifier NETHERITE_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/netherite_shield_base_nopattern"));

	/**
	 * Tech Reborn
	 */
	//Bronze
	private ShieldEntityModel bronzeShieldModel;
	private static final SpriteIdentifier BRONZE_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/bronze_shield_base"));
	private static final SpriteIdentifier BRONZE_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/bronze_shield_base_nopattern"));

	//Ruby
	private ShieldEntityModel rubyShieldModel;
	private static final SpriteIdentifier RUBY_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/ruby_shield_base"));
	private static final SpriteIdentifier RUBY_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/ruby_shield_base_nopattern"));

	//Peridot
	private ShieldEntityModel peridotShieldModel;
	private static final SpriteIdentifier PERIDOT_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/peridot_shield_base"));
	private static final SpriteIdentifier PERIDOT_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/peridot_shield_base_nopattern"));

	//Sapphire
	private ShieldEntityModel sapphireShieldModel;
	private static final SpriteIdentifier SAPPHIRE_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/sapphire_shield_base"));
	private static final SpriteIdentifier SAPPHIRE_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/sapphire_shield_base_nopattern"));

	@Final
	@Shadow
	private EntityModelLoader entityModelLoader;


	@Inject(method = "reload", at = @At("HEAD"))
	private void setModels(CallbackInfo ci){

		//Wooden
		woodenShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.wooden_shield_model_layer));

		//Golden
		goldenShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.golden_shield_model_layer));

		//Diamond
		diamondShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.diamond_shield_model_layer));

		//Netherite
		netheriteShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.netherite_shield_model_layer));

		if(FabricLoader.getInstance().isModLoaded("techreborn")) {

			//Bronze
			bronzeShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.bronze_shield_model_layer));

			//Ruby
			rubyShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.ruby_shield_model_layer));

			//Peridot
			peridotShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.peridot_shield_model_layer));

			//Sapphire
			sapphireShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.sapphire_shield_model_layer));
		}
	}

	@Inject(method = "render", at = @At("HEAD"))
	private void mainRender(ItemStack stack, ModelTransformation.Mode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, CallbackInfo ci) {

		//Wooden
		if (stack.isOf(ModItems.wooden_shield.getItem())) {
			FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, woodenShieldModel, WOODEN_SHIELD_BASE, WOODEN_SHIELD_BASE_NO_PATTERN);
		}

		//Golden
		if (stack.isOf(ModItems.golden_shield.getItem())) {
			FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, goldenShieldModel, GOLDEN_SHIELD_BASE, GOLDEN_SHIELD_BASE_NO_PATTERN);
		}

		//Diamond
		if (stack.isOf(ModItems.diamond_shield.getItem())) {
			FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, diamondShieldModel, DIAMOND_SHIELD_BASE, DIAMOND_SHIELD_BASE_NO_PATTERN);
		}

		//Netherite
		if (stack.isOf(ModItems.netherite_shield.getItem())) {
			FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, netheriteShieldModel, NETHERITE_SHIELD_BASE, NETHERITE_SHIELD_BASE_NO_PATTERN);
		}

		if(FabricLoader.getInstance().isModLoaded("techreborn")) {
			//Bronze
			if (stack.isOf(ModItems.bronze_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, bronzeShieldModel, BRONZE_SHIELD_BASE, BRONZE_SHIELD_BASE_NO_PATTERN);
			}

			//Ruby
			if (stack.isOf(ModItems.ruby_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, rubyShieldModel, RUBY_SHIELD_BASE, RUBY_SHIELD_BASE_NO_PATTERN);
			}

			//Peridot
			if (stack.isOf(ModItems.peridot_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, peridotShieldModel, PERIDOT_SHIELD_BASE, PERIDOT_SHIELD_BASE_NO_PATTERN);
			}

			//Sapphire
			if (stack.isOf(ModItems.sapphire_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, sapphireShieldModel, SAPPHIRE_SHIELD_BASE, SAPPHIRE_SHIELD_BASE_NO_PATTERN);
			}
		}
	}
}