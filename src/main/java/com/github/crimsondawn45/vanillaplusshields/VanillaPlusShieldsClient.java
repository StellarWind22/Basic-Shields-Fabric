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
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/test_shield_base"));
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/test_shield_base_nopattern"));
        });

        //Gold

        //Diamond

        //Netherrite
    }
}
