package com.github.crimsondawn45.basicshields.mixin;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.basicshields.initializers.BasicShieldsClient;
import com.github.crimsondawn45.fabricshieldlib.initializers.FabricShieldLibClient;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

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

@SuppressWarnings( "deprecation" )
@Mixin(BuiltinModelItemRenderer.class)
public class RendererMixin {

	/**
	 * Vanilla
	 */
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

	//TODO: this is temorarily using wood textures until others are done fix later.

	/**
	 * Adabranium
	 */
	//Nether
	private ShieldEntityModel netherShieldModel;
	private static final SpriteIdentifier NETHER_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/nether_shield_base"));
	private static final SpriteIdentifier NETHER_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/nether_shield_base_nopattern"));

	//Vibranium
	private ShieldEntityModel vibraniumShieldModel;
	private static final SpriteIdentifier VIBRANIUM_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/vibranium_shield_base"));
	private static final SpriteIdentifier VIBRANIUM_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/vibranium_shield_base_nopattern"));

	//Adamantium
	private ShieldEntityModel adamantiumShieldModel;
	private static final SpriteIdentifier ADAMANTIUM_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/wooden_shield_base"));
	private static final SpriteIdentifier ADAMANTIUM_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/wooden_shield_base_nopattern"));

	/**
	 * Gobber
	 */
	//Gobber
	private ShieldEntityModel gobberShieldModel;
	private static final SpriteIdentifier GOBBER_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/wooden_shield_base"));
	private static final SpriteIdentifier GOBBER_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/wooden_shield_base_nopattern"));

	//Gobber Nether
	private ShieldEntityModel gobberNetherShieldModel;
	private static final SpriteIdentifier GOBBER_NETHER_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/wooden_shield_base"));
	private static final SpriteIdentifier GOBBER_NETHER_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/wooden_shield_base_nopattern"));

	//Gobber End
	private ShieldEntityModel gobberEndShieldModel;
	private static final SpriteIdentifier GOBBER_END_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/wooden_shield_base"));
	private static final SpriteIdentifier GOBBER_END_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/wooden_shield_base_nopattern"));

	@Final
	@Shadow
	private EntityModelLoader entityModelLoader;


	@Inject(method = "reload", at = @At("HEAD"))
	private void setModels(CallbackInfo ci){

		/**
		 * Vanilla
		 */
		if(BasicShields.vanilla.isLoaded()) {
			//Wooden
			woodenShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.wooden_shield_model_layer));

			//Golden
			goldenShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.golden_shield_model_layer));

			//Diamond
			diamondShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.diamond_shield_model_layer));

			//Netherite
			netheriteShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.netherite_shield_model_layer));
		}

		/**
		 * TechReborn
		 */
		if(BasicShields.techReborn.isLoaded()) {

			//Bronze
			bronzeShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.bronze_shield_model_layer));

			//Ruby
			rubyShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.ruby_shield_model_layer));

			//Peridot
			peridotShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.peridot_shield_model_layer));

			//Sapphire
			sapphireShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.sapphire_shield_model_layer));
		}

		/**
		 * Adabranium
		 */
		if(BasicShields.adabranium.isLoaded()) {

			//Nether
			netherShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.nether_shield_model_layer));

			//Vibranium
			vibraniumShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.vibranium_shield_model_layer));

			//Adamantium
			adamantiumShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.adamantium_shield_model_layer));
		}

		/**
		 * Gobber
		 */
		if(BasicShields.gobber.isLoaded()) {

			//Gobber
			gobberShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.gobber_shield_model_layer));

			//Gobber Nether
			gobberNetherShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.gobber_nether_shield_model_layer));

			//Gobber End
			gobberEndShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.gobber_end_shield_model_layer));
		}
	}

	@Inject(method = "render", at = @At("HEAD"))
	private void mainRender(ItemStack stack, ModelTransformation.Mode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, CallbackInfo ci) {

		/**
		 * Vanilla
		 */
		if(BasicShields.vanilla.isLoaded()) {
			//Wooden
			if (stack.isOf(BasicShields.vanilla.wooden_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, woodenShieldModel, WOODEN_SHIELD_BASE, WOODEN_SHIELD_BASE_NO_PATTERN);
			}

			//Golden
			if (stack.isOf(BasicShields.vanilla.golden_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, goldenShieldModel, GOLDEN_SHIELD_BASE, GOLDEN_SHIELD_BASE_NO_PATTERN);
			}

			//Diamond
			if (stack.isOf(BasicShields.vanilla.diamond_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, diamondShieldModel, DIAMOND_SHIELD_BASE, DIAMOND_SHIELD_BASE_NO_PATTERN);
			}

			//Netherite
			if (stack.isOf(BasicShields.vanilla.netherite_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, netheriteShieldModel, NETHERITE_SHIELD_BASE, NETHERITE_SHIELD_BASE_NO_PATTERN);
			}
		}

		/**
		 * TechReborn
		 */
		if(BasicShields.techReborn.isLoaded()) {
			//Bronze
			if (stack.isOf(BasicShields.techReborn.bronze_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, bronzeShieldModel, BRONZE_SHIELD_BASE, BRONZE_SHIELD_BASE_NO_PATTERN);
			}

			//Ruby
			if (stack.isOf(BasicShields.techReborn.ruby_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, rubyShieldModel, RUBY_SHIELD_BASE, RUBY_SHIELD_BASE_NO_PATTERN);
			}

			//Peridot
			if (stack.isOf(BasicShields.techReborn.peridot_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, peridotShieldModel, PERIDOT_SHIELD_BASE, PERIDOT_SHIELD_BASE_NO_PATTERN);
			}

			//Sapphire
			if (stack.isOf(BasicShields.techReborn.sapphire_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, sapphireShieldModel, SAPPHIRE_SHIELD_BASE, SAPPHIRE_SHIELD_BASE_NO_PATTERN);
			}
		}

		/**
		 * Adabranium
		 */
		if(BasicShields.adabranium.isLoaded()) {

			//Nether
			if (stack.isOf(BasicShields.adabranium.nether_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, netherShieldModel, NETHER_SHIELD_BASE, NETHER_SHIELD_BASE_NO_PATTERN);
			}

			//Vibranium
			if (stack.isOf(BasicShields.adabranium.vibranium_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, vibraniumShieldModel, VIBRANIUM_SHIELD_BASE, VIBRANIUM_SHIELD_BASE_NO_PATTERN);
			}

			//Adamantium
			if (stack.isOf(BasicShields.adabranium.adamantium_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, adamantiumShieldModel, ADAMANTIUM_SHIELD_BASE, ADAMANTIUM_SHIELD_BASE_NO_PATTERN);
			}
		}

		/**
		 * Gobber
		 */
		if(BasicShields.gobber.isLoaded()) {

			//Gobber
			if (stack.isOf(BasicShields.gobber.gobber_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, gobberShieldModel, GOBBER_SHIELD_BASE, GOBBER_SHIELD_BASE_NO_PATTERN);
			}

			//Gobber Nether
			if (stack.isOf(BasicShields.gobber.gobber_nether_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, gobberNetherShieldModel, GOBBER_NETHER_SHIELD_BASE, GOBBER_NETHER_SHIELD_BASE_NO_PATTERN);
			}

			//Gobber End
			if (stack.isOf(BasicShields.gobber.gobber_end_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, gobberEndShieldModel, GOBBER_END_SHIELD_BASE, GOBBER_END_SHIELD_BASE_NO_PATTERN);
			}
		}
	}
}