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

        //Wood
        EntityModelLayerRegistry.registerModelLayer(VanillaPlusShields.wood_shield_model_layer, ShieldEntityModel::getTexturedModelData);

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/wood_shield_base"));
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/wood_shield_base_no_pattern"));
        });

        //Gold
        EntityModelLayerRegistry.registerModelLayer(VanillaPlusShields.gold_shield_model_layer, ShieldEntityModel::getTexturedModelData);

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/gold_shield_base"));
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/gold_shield_base_no_pattern"));
        });

        //Diamond
        EntityModelLayerRegistry.registerModelLayer(VanillaPlusShields.diamond_shield_model_layer, ShieldEntityModel::getTexturedModelData);

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/diamond_shield_base"));
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/diamond_shield_base_no_pattern"));
        });

        //Netherrite
        EntityModelLayerRegistry.registerModelLayer(VanillaPlusShields.netherrite_shield_model_layer, ShieldEntityModel::getTexturedModelData);

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/netherrite_shield_base"));
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/netherrite_shield_base_no_pattern"));
        });
    }
}
