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
	 * Alexandrite
	 */
	private ShieldEntityModel alexandriteShieldModel;
	private static final SpriteIdentifier ALEXANDRITE_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/alexandrite_shield_base"));
	private static final SpriteIdentifier ALEXANDRITE_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/alexandrite_shield_base_nopattern"));

	/**
	 * Bronze
	 */
	private ShieldEntityModel bronzeShieldModel;
	private static final SpriteIdentifier BRONZE_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/bronze_shield_base"));
	private static final SpriteIdentifier BRONZE_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/bronze_shield_base_nopattern"));

	/**
	 * Carbonado
	 */
	private ShieldEntityModel carbonadoShieldModel;
	private static final SpriteIdentifier CARBONADO_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/carbonado_shield_base"));
	private static final SpriteIdentifier CARBONADO_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/carbonado_shield_base_nopattern"));

	/**
	 * Citrine
	 */
	private ShieldEntityModel citrineShieldModel;
	private static final SpriteIdentifier CITRINE_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/citrine_shield_base"));
	private static final SpriteIdentifier CITRINE_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/citrine_shield_base_nopattern"));

	/**
	 * Corundum
	 */
	private ShieldEntityModel corundumShieldModel;
	private static final SpriteIdentifier CORUNDUM_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/corundum_shield_base"));
	private static final SpriteIdentifier CORUNDUM_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/corundum_shield_base_nopattern"));

	/**
	 * Kunzite
	 */
	private ShieldEntityModel kunziteShieldModel;
	private static final SpriteIdentifier KUNZITE_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/kunzite_shield_base"));
	private static final SpriteIdentifier KUNZITE_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/kunzite_shield_base_nopattern"));

	/**
	 * Moissanite
	 */
	private ShieldEntityModel moissaniteShieldModel;
	private static final SpriteIdentifier MOISSANITE_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/moissanite_shield_base"));
	private static final SpriteIdentifier MOISSANITE_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/moissanite_shield_base_nopattern"));

	/**
	 * Spinel
	 */
	private ShieldEntityModel spinelShieldModel;
	private static final SpriteIdentifier SPINEL_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/spinel_shield_base"));
	private static final SpriteIdentifier SPINEL_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/spinel_shield_base_nopattern"));

	/**
	 * Topaz
	 */
	private ShieldEntityModel topazShieldModel;
	private static final SpriteIdentifier TOPAZ_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/topaz_shield_base"));
	private static final SpriteIdentifier TOPAZ_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/topaz_shield_base_nopattern"));

	/**
	 * Tourmaline
	 */
	private ShieldEntityModel tourmalineShieldModel;
	private static final SpriteIdentifier TOURMALINE_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/tourmaline_shield_base"));
	private static final SpriteIdentifier TOURMALINE_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/tourmaline_shield_base_nopattern"));
	
	/**
	 * Ruby
	 */
	private ShieldEntityModel rubyShieldModel;
	private static final SpriteIdentifier RUBY_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/ruby_shield_base"));
	private static final SpriteIdentifier RUBY_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/ruby_shield_base_nopattern"));

	/**
	 * Peridot
	 */
	private ShieldEntityModel peridotShieldModel;
	private static final SpriteIdentifier PERIDOT_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/peridot_shield_base"));
	private static final SpriteIdentifier PERIDOT_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/peridot_shield_base_nopattern"));

	/**
	 * Sapphire
	 */
	private ShieldEntityModel sapphireShieldModel;
	private static final SpriteIdentifier SAPPHIRE_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/sapphire_shield_base"));
	private static final SpriteIdentifier SAPPHIRE_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/sapphire_shield_base_nopattern"));

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
	private static final SpriteIdentifier ADAMANTIUM_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/adamantium_shield_base"));
	private static final SpriteIdentifier ADAMANTIUM_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/adamantium_shield_base_nopattern"));

	/**
	 * Gobber
	 */
	//Gobber
	private ShieldEntityModel gobberShieldModel;
	private static final SpriteIdentifier GOBBER_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/gobber_shield_base"));
	private static final SpriteIdentifier GOBBER_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/gobber_shield_base_nopattern"));

	//Gobber Nether
	private ShieldEntityModel gobberNetherShieldModel;
	private static final SpriteIdentifier GOBBER_NETHER_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/gobber_nether_shield_base"));
	private static final SpriteIdentifier GOBBER_NETHER_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/gobber_nether_shield_base_nopattern"));

	//Gobber End
	private ShieldEntityModel gobberEndShieldModel;
	private static final SpriteIdentifier GOBBER_END_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/gobber_end_shield_base"));
	private static final SpriteIdentifier GOBBER_END_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/gobber_end_shield_base_nopattern"));

	//Gobber Dragon
	private ShieldEntityModel gobberDragonShieldModel;
	private static final SpriteIdentifier GOBBER_DRAGON_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/gobber_dragon_shield_base"));
	private static final SpriteIdentifier GOBBER_DRAGON_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/gobber_dragon_shield_base_nopattern"));


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
		 * Alexandrite
		 */
		if(BasicShields.alexandrite.isLoaded()) {
			alexandriteShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.alexandrite_shield_model_layer));
		}

		/**
		 * Bronze
		 */
		if(BasicShields.bronze.isLoaded()) {
			bronzeShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.bronze_shield_model_layer));
		}

		/**
		 * Carbonado
		 */
		if(BasicShields.carbonado.isLoaded()) {
			carbonadoShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.carbonado_shield_model_layer));
		}

		/**
		 * Citrine
		 */
		if(BasicShields.citrine.isLoaded()) {
			citrineShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.citrine_shield_model_layer));
		}

		/**
		 * Corundum
		 */
		if(BasicShields.corundum.isLoaded()) {
			corundumShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.corundum_shield_model_layer));
		}

		/**
		 * Kunzite
		 */
		if(BasicShields.kunzite.isLoaded()) {
			kunziteShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.kunzite_shield_model_layer));
		}

		/**
		 * Moissanite
		 */
		if(BasicShields.moissanite.isLoaded()) {
			moissaniteShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.moissanite_shield_model_layer));
		}

		/**
		 * Spinel
		 */
		if(BasicShields.spinel.isLoaded()) {
			spinelShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.spinel_shield_model_layer));
		}

		/**
		 * Topaz
		 */
		if(BasicShields.topaz.isLoaded()) {
			topazShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.topaz_shield_model_layer));
		}

		/**
		 * Tourmaline
		 */
		if(BasicShields.tourmaline.isLoaded()) {
			tourmalineShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.tourmaline_shield_model_layer));
		}
		
		/**
		 * Ruby
		 */
		if(BasicShields.ruby.isLoaded()) {
			rubyShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.ruby_shield_model_layer));
		}

		/**
		 * Peridot
		 */
		if(BasicShields.peridot.isLoaded()) {
			peridotShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.peridot_shield_model_layer));
		}

		/**
		 * Sapphire
		 */
		if(BasicShields.sapphire.isLoaded()) {
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

			//Gobber Dragon
			gobberDragonShieldModel = new ShieldEntityModel(this.entityModelLoader.getModelPart(BasicShieldsClient.gobber_dragon_shield_model_layer));
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
		 * Alexandrite
		 */
		if(BasicShields.alexandrite.isLoaded()) {
			if (stack.isOf(BasicShields.alexandrite.alexandrite_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, alexandriteShieldModel, ALEXANDRITE_SHIELD_BASE, ALEXANDRITE_SHIELD_BASE_NO_PATTERN);
			}
		}

		/**
		 * Bronze
		 */
		if(BasicShields.bronze.isLoaded()) {
			if (stack.isOf(BasicShields.bronze.bronze_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, bronzeShieldModel, BRONZE_SHIELD_BASE, BRONZE_SHIELD_BASE_NO_PATTERN);
			}
		}

		/**
		 * Carbonado
		 */
		if(BasicShields.carbonado.isLoaded()) {
			if (stack.isOf(BasicShields.carbonado.carbonado_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, carbonadoShieldModel, CARBONADO_SHIELD_BASE, CARBONADO_SHIELD_BASE_NO_PATTERN);
			}
		}

		/**
		 * Citrine
		 */
		if(BasicShields.citrine.isLoaded()) {
			if (stack.isOf(BasicShields.citrine.citrine_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, citrineShieldModel, CITRINE_SHIELD_BASE, CITRINE_SHIELD_BASE_NO_PATTERN);
			}
		}

		/**
		 * Corundum
		 */
		if(BasicShields.corundum.isLoaded()) {
			if (stack.isOf(BasicShields.corundum.corundum_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, corundumShieldModel, CORUNDUM_SHIELD_BASE, CORUNDUM_SHIELD_BASE_NO_PATTERN);
			}
		}

		/**
		 * Kunzite
		 */
		if(BasicShields.kunzite.isLoaded()) {
			if (stack.isOf(BasicShields.kunzite.kunzite_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, kunziteShieldModel, KUNZITE_SHIELD_BASE, KUNZITE_SHIELD_BASE_NO_PATTERN);
			}
		}

		/**
		 * Moissanite
		 */
		if(BasicShields.moissanite.isLoaded()) {
			if (stack.isOf(BasicShields.moissanite.moissanite_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, moissaniteShieldModel, MOISSANITE_SHIELD_BASE, MOISSANITE_SHIELD_BASE_NO_PATTERN);
			}
		}

		/**
		 * Spinel
		 */
		if(BasicShields.spinel.isLoaded()) {
			if (stack.isOf(BasicShields.spinel.spinel_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, spinelShieldModel, SPINEL_SHIELD_BASE, SPINEL_SHIELD_BASE_NO_PATTERN);
			}
		}

		/**
		 * Topaz
		 */
		if(BasicShields.topaz.isLoaded()) {
			if (stack.isOf(BasicShields.topaz.topaz_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, topazShieldModel, TOPAZ_SHIELD_BASE, TOPAZ_SHIELD_BASE_NO_PATTERN);
			}
		}

		/**
		 * Tourmaline
		 */
		if(BasicShields.tourmaline.isLoaded()) {
			if (stack.isOf(BasicShields.tourmaline.tourmaline_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, tourmalineShieldModel, TOURMALINE_SHIELD_BASE, TOURMALINE_SHIELD_BASE_NO_PATTERN);
			}
		}

		/**
		 * Ruby
		 */
		if(BasicShields.ruby.isLoaded()) {
			if (stack.isOf(BasicShields.ruby.ruby_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, rubyShieldModel, RUBY_SHIELD_BASE, RUBY_SHIELD_BASE_NO_PATTERN);
			}
		}

		/**
		 * Peridot
		 */
		if(BasicShields.peridot.isLoaded()) {
			if (stack.isOf(BasicShields.peridot.peridot_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, peridotShieldModel, PERIDOT_SHIELD_BASE, PERIDOT_SHIELD_BASE_NO_PATTERN);
			}
		}

		/**
		 * Sapphire
		 */
		if(BasicShields.sapphire.isLoaded()) {
			if (stack.isOf(BasicShields.sapphire.sapphire_shield.getItem())) {
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

			//Gobber Dragon
			if (stack.isOf(BasicShields.gobber.gobber_dragon_shield.getItem())) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, gobberDragonShieldModel, GOBBER_DRAGON_SHIELD_BASE, GOBBER_DRAGON_SHIELD_BASE_NO_PATTERN);
			}
		}
	}
}