package com.github.crimsondawn45.basicshields.mixin;

import com.github.crimsondawn45.basicshields.BasicShields;
import com.github.crimsondawn45.basicshields.registry.ModItems;
import com.github.crimsondawn45.fabricshieldlib.initializers.FabricShieldLibClient;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

@Mixin(BuiltinModelItemRenderer.class)
public class RendererMixin {

	//Wooden
	private static final SpriteIdentifier WOODEN_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier(BasicShields.MOD_ID,"entity/wooden_shield_base"));
	private static final SpriteIdentifier WOODEN_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier(BasicShields.MOD_ID,"entity/wooden_shield_base_nopattern"));

	//Golden
	private static final SpriteIdentifier GOLDEN_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier(BasicShields.MOD_ID,"entity/golden_shield_base"));
	private static final SpriteIdentifier GOLDEN_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier(BasicShields.MOD_ID,"entity/golden_shield_base_nopattern"));

	//Diamond
	private static final SpriteIdentifier DIAMOND_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier(BasicShields.MOD_ID,"entity/diamond_shield_base"));
	private static final SpriteIdentifier DIAMOND_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier(BasicShields.MOD_ID,"entity/diamond_shield_base_nopattern"));

	//Netherite
	//private static final SpriteIdentifier NETHERITE_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier(BasicShields.MOD_ID,"entity/netherite_shield_base"));
	//private static final SpriteIdentifier NETHERITE_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier(BasicShields.MOD_ID,"entity/netherite_shield_base_nopattern"));

	/**
	 * Tech Reborn
	 */
	//Bronze
	private static final SpriteIdentifier BRONZE_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier(BasicShields.MOD_ID,"entity/bronze_shield_base"));
	private static final SpriteIdentifier BRONZE_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier(BasicShields.MOD_ID,"entity/bronze_shield_base_nopattern"));

	//Ruby
	private static final SpriteIdentifier RUBY_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier(BasicShields.MOD_ID,"entity/ruby_shield_base"));
	private static final SpriteIdentifier RUBY_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier(BasicShields.MOD_ID,"entity/ruby_shield_base_nopattern"));

	//Peridot
	private static final SpriteIdentifier PERIDOT_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier(BasicShields.MOD_ID,"entity/peridot_shield_base"));
	private static final SpriteIdentifier PERIDOT_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier(BasicShields.MOD_ID,"entity/peridot_shield_base_nopattern"));

	//Sapphire
	private static final SpriteIdentifier SAPPHIRE_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier(BasicShields.MOD_ID,"entity/sapphire_shield_base"));
	private static final SpriteIdentifier SAPPHIRE_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier(BasicShields.MOD_ID,"entity/sapphire_shield_base_nopattern"));

	@Inject(method = "render", at = @At("HEAD"))
	private void mainRender(ItemStack stack, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, CallbackInfo ci) {

		//Wooden
		if (stack.getItem() == (ModItems.wooden_shield.getItem())) {
			FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), WOODEN_SHIELD_BASE, WOODEN_SHIELD_BASE_NO_PATTERN);
		}

		//Golden
		if (stack.getItem() == ModItems.golden_shield.getItem()) {
			FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), GOLDEN_SHIELD_BASE, GOLDEN_SHIELD_BASE_NO_PATTERN);
		}

		//Diamond
		if (stack.getItem() == ModItems.diamond_shield.getItem()) {
			FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), DIAMOND_SHIELD_BASE, DIAMOND_SHIELD_BASE_NO_PATTERN);
		}

		//Netherite
		/*
		if (stack.getItem() == ModItems.netherite_shield.getItem()) {
			FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), NETHERITE_SHIELD_BASE, NETHERITE_SHIELD_BASE_NO_PATTERN);
		}
		*/

		if(FabricLoader.getInstance().isModLoaded("techreborn")) {
			//Bronze
			if (stack.getItem() == ModItems.bronze_shield.getItem()) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), BRONZE_SHIELD_BASE, BRONZE_SHIELD_BASE_NO_PATTERN);
			}

			//Ruby
			if (stack.getItem() == ModItems.ruby_shield.getItem()) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), RUBY_SHIELD_BASE, RUBY_SHIELD_BASE_NO_PATTERN);
			}

			//Peridot
			if (stack.getItem() == ModItems.peridot_shield.getItem()) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), PERIDOT_SHIELD_BASE, PERIDOT_SHIELD_BASE_NO_PATTERN);
			}

			//Sapphire
			if (stack.getItem() == ModItems.sapphire_shield.getItem()) {
				FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, new ShieldEntityModel(), SAPPHIRE_SHIELD_BASE, SAPPHIRE_SHIELD_BASE_NO_PATTERN);
			}
		}
	}
}