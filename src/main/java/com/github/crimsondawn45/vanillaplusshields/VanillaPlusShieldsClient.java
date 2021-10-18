package com.github.crimsondawn45.vanillaplusshields;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.Identifier;

public class VanillaPlusShieldsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        //Wooden
        EntityModelLayerRegistry.registerModelLayer(VanillaPlusShields.wooden_shield_model_layer, ShieldEntityModel::getTexturedModelData);

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/wooden_shield_base"));
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/wooden_shield_base_nopattern"));
        });

        //Golden
        EntityModelLayerRegistry.registerModelLayer(VanillaPlusShields.golden_shield_model_layer, ShieldEntityModel::getTexturedModelData);

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/golden_shield_base"));
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/golden_shield_base_nopattern"));
        });

        //Diamond
        EntityModelLayerRegistry.registerModelLayer(VanillaPlusShields.diamond_shield_model_layer, ShieldEntityModel::getTexturedModelData);

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/diamond_shield_base"));
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/diamond_shield_base_nopattern"));
        });

        //Netherite
        EntityModelLayerRegistry.registerModelLayer(VanillaPlusShields.netherite_shield_model_layer, ShieldEntityModel::getTexturedModelData);

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/netherite_shield_base"));
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/netherite_shield_base_nopattern"));
        });
    }
}
