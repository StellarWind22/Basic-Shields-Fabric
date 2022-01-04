package com.github.crimsondawn45.basicshields.mixin;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.fabricshieldlib.initializers.FabricShieldLibClient;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.render.VertexConsumerProvider;
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

	/**
	 * Vanilla
	 */
	//Wooden
	private static final SpriteIdentifier WOODEN_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/wooden_shield_base"));
	private static final SpriteIdentifier WOODEN_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/wooden_shield_base_nopattern"));

	//Golden
	private static final SpriteIdentifier GOLDEN_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/golden_shield_base"));
	private static final SpriteIdentifier GOLDEN_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/golden_shield_base_nopattern"));

	//Diamond
	private static final SpriteIdentifier DIAMOND_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/diamond_shield_base"));
	private static final SpriteIdentifier DIAMOND_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/diamond_shield_base_nopattern"));

	//Netherite
	private static final SpriteIdentifier NETHERITE_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/netherite_shield_base"));
	private static final SpriteIdentifier NETHERITE_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/netherite_shield_base_nopattern"));

	/**
	 * Tech Reborn
	 */
	//Bronze
	private static final SpriteIdentifier BRONZE_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/bronze_shield_base"));
	private static final SpriteIdentifier BRONZE_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/bronze_shield_base_nopattern"));

	//Ruby
	private static final SpriteIdentifier RUBY_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/ruby_shield_base"));
	private static final SpriteIdentifier RUBY_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/ruby_shield_base_nopattern"));

	//Peridot
	private static final SpriteIdentifier PERIDOT_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/peridot_shield_base"));
	private static final SpriteIdentifier PERIDOT_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/peridot_shield_base_nopattern"));

	//Sapphire
	private static final SpriteIdentifier SAPPHIRE_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/sapphire_shield_base"));
	private static final SpriteIdentifier SAPPHIRE_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/sapphire_shield_base_nopattern"));

	/**
	 * Adabranium
	 */
	//Nether
	private static final SpriteIdentifier NETHER_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/nether_shield_base"));
	private static final SpriteIdentifier NETHER_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/nether_shield_base_nopattern"));

	//Vibranium
	private static final SpriteIdentifier VIBRANIUM_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/vibranium_shield_base"));
	private static final SpriteIdentifier VIBRANIUM_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/vibranium_shield_base_nopattern"));

	//Adamantium
	private static final SpriteIdentifier ADAMANTIUM_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/adamantium_shield_base"));
	private static final SpriteIdentifier ADAMANTIUM_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/adamantium_shield_base_nopattern"));

	/**
	 * Gobber
	 */
	//Gobber
	private static final SpriteIdentifier GOBBER_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/gobber_shield_base"));
	private static final SpriteIdentifier GOBBER_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/gobber_shield_base_nopattern"));

	//Gobber Nether
	private static final SpriteIdentifier GOBBER_NETHER_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/gobber_nether_shield_base"));
	private static final SpriteIdentifier GOBBER_NETHER_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/gobber_nether_shield_base_nopattern"));

	//Gobber End
	private static final SpriteIdentifier GOBBER_END_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/gobber_end_shield_base"));
	private static final SpriteIdentifier GOBBER_END_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/gobber_end_shield_base_nopattern"));

	//Gobber Dragon
	private static final SpriteIdentifier GOBBER_DRAGON_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/gobber_dragon_shield_base"));
	private static final SpriteIdentifier GOBBER_DRAGON_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID,"entity/gobber_dragon_shield_base_nopattern"));

	@Inject(method = "render", at = @At("HEAD"))
	private void mainRender(ItemStack stack, ModelTransformation.Mode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, CallbackInfo ci) {

		/**
		 * Vanilla
		 */
		if(BasicShields.vanilla.isLoaded()) {
			//Wooden
			if (stack.getItem() == BasicShields.vanilla.wooden_shield.getItem()) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), WOODEN_SHIELD_BASE, WOODEN_SHIELD_BASE_NO_PATTERN);
			}

			//Golden
			if (stack.getItem() == BasicShields.vanilla.golden_shield.getItem()) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), GOLDEN_SHIELD_BASE, GOLDEN_SHIELD_BASE_NO_PATTERN);
			}

			//Diamond
			if (stack.getItem() == BasicShields.vanilla.diamond_shield.getItem()) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), DIAMOND_SHIELD_BASE, DIAMOND_SHIELD_BASE_NO_PATTERN);
			}

			//Netherite
			if (stack.getItem() == BasicShields.vanilla.netherite_shield.getItem()) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), NETHERITE_SHIELD_BASE, NETHERITE_SHIELD_BASE_NO_PATTERN);
			}
		}

		/**
		 * TechReborn
		 */
		if(BasicShields.techReborn.isLoaded()) {
			//Bronze
			if (stack.getItem() == BasicShields.techReborn.bronze_shield.getItem()) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), BRONZE_SHIELD_BASE, BRONZE_SHIELD_BASE_NO_PATTERN);
			}

			//Ruby
			if (stack.getItem() == BasicShields.techReborn.ruby_shield.getItem()) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), RUBY_SHIELD_BASE, RUBY_SHIELD_BASE_NO_PATTERN);
			}

			//Peridot
			if (stack.getItem() == BasicShields.techReborn.peridot_shield.getItem()) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), PERIDOT_SHIELD_BASE, PERIDOT_SHIELD_BASE_NO_PATTERN);
			}

			//Sapphire
			if (stack.getItem() == BasicShields.techReborn.sapphire_shield.getItem()) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), SAPPHIRE_SHIELD_BASE, SAPPHIRE_SHIELD_BASE_NO_PATTERN);
			}
		}

		/**
		 * Adabranium
		 */
		if(BasicShields.adabranium.isLoaded()) {

			//Nether
			if (stack.getItem() == BasicShields.adabranium.nether_shield.getItem()) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), NETHER_SHIELD_BASE, NETHER_SHIELD_BASE_NO_PATTERN);
			}

			//Vibranium
			if (stack.getItem() == BasicShields.adabranium.vibranium_shield.getItem()) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), VIBRANIUM_SHIELD_BASE, VIBRANIUM_SHIELD_BASE_NO_PATTERN);
			}

			//Adamantium
			if (stack.getItem() == BasicShields.adabranium.adamantium_shield.getItem()) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), ADAMANTIUM_SHIELD_BASE, ADAMANTIUM_SHIELD_BASE_NO_PATTERN);
			}
		}

		/**
		 * Gobber
		 */
		if(BasicShields.gobber.isLoaded()) {

			//Gobber
			if (stack.getItem() == BasicShields.gobber.gobber_shield.getItem()) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), GOBBER_SHIELD_BASE, GOBBER_SHIELD_BASE_NO_PATTERN);
			}

			//Gobber Nether
			if (stack.getItem() == BasicShields.gobber.gobber_nether_shield.getItem()) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), GOBBER_NETHER_SHIELD_BASE, GOBBER_NETHER_SHIELD_BASE_NO_PATTERN);
			}

			//Gobber End
			if (stack.getItem() == BasicShields.gobber.gobber_end_shield.getItem()) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), GOBBER_END_SHIELD_BASE, GOBBER_END_SHIELD_BASE_NO_PATTERN);
			}

			//Gobber Dragon
			if (stack.getItem() == BasicShields.gobber.gobber_dragon_shield.getItem()) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), GOBBER_DRAGON_SHIELD_BASE, GOBBER_DRAGON_SHIELD_BASE_NO_PATTERN);
			}
		}
	}
}