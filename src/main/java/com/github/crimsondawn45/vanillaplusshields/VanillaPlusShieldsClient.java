package com.github.crimsondawn45.vanillaplusshields;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.Identifier;

public class VanillaPlusShieldsClient implements ClientModInitializer {

    public static final EntityModelLayer wooden_shield_model_layer = new EntityModelLayer(new Identifier(VanillaPlusShields.MOD_ID, "wooden_shield"),"main");
    
    public static final EntityModelLayer golden_shield_model_layer = new EntityModelLayer(new Identifier(VanillaPlusShields.MOD_ID, "golden_shield"),"main");

    public static final EntityModelLayer diamond_shield_model_layer = new EntityModelLayer(new Identifier(VanillaPlusShields.MOD_ID, "diamond_shield"),"main");

    public static final EntityModelLayer netherite_shield_model_layer = new EntityModelLayer(new Identifier(VanillaPlusShields.MOD_ID, "netherite_shield"),"main");

    @Override
    public void onInitializeClient() {

        //Wooden
        EntityModelLayerRegistry.registerModelLayer(wooden_shield_model_layer, ShieldEntityModel::getTexturedModelData);

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/wooden_shield_base"));
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/wooden_shield_base_nopattern"));
        });

        //Golden
        EntityModelLayerRegistry.registerModelLayer(golden_shield_model_layer, ShieldEntityModel::getTexturedModelData);

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/golden_shield_base"));
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/golden_shield_base_nopattern"));
        });

        //Diamond
        EntityModelLayerRegistry.registerModelLayer(diamond_shield_model_layer, ShieldEntityModel::getTexturedModelData);

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/diamond_shield_base"));
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/diamond_shield_base_nopattern"));
        });

        //Netherite
        EntityModelLayerRegistry.registerModelLayer(netherite_shield_model_layer, ShieldEntityModel::getTexturedModelData);

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/netherite_shield_base"));
            registry.register(new Identifier(VanillaPlusShields.MOD_ID, "entity/netherite_shield_base_nopattern"));
        });
    }
}
