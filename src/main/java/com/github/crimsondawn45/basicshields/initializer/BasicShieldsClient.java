package com.github.crimsondawn45.basicshields.initializer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.Identifier;

@SuppressWarnings("deprecation")
public class BasicShieldsClient implements ClientModInitializer {

    //Vanilla
    public static final EntityModelLayer wooden_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "wooden_shield"),"main");
    public static final EntityModelLayer golden_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "golden_shield"),"main");
    public static final EntityModelLayer diamond_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "diamond_shield"),"main");
    public static final EntityModelLayer netherite_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "netherite_shield"),"main");

    //Techreborn
    public static final EntityModelLayer bronze_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "bronze_shield"),"main");
    public static final EntityModelLayer ruby_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "ruby_shield"),"main");
    public static final EntityModelLayer peridot_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "peridot_shield"),"main");
    public static final EntityModelLayer sapphire_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "sapphire_shield"),"main");

    @Override
    public void onInitializeClient() {

        //Wooden
        EntityModelLayerRegistry.registerModelLayer(wooden_shield_model_layer, ShieldEntityModel::getTexturedModelData);

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier(BasicShields.MOD_ID, "entity/wooden_shield_base"));
            registry.register(new Identifier(BasicShields.MOD_ID, "entity/wooden_shield_base_nopattern"));
        });

        //Golden
        EntityModelLayerRegistry.registerModelLayer(golden_shield_model_layer, ShieldEntityModel::getTexturedModelData);

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier(BasicShields.MOD_ID, "entity/golden_shield_base"));
            registry.register(new Identifier(BasicShields.MOD_ID, "entity/golden_shield_base_nopattern"));
        });

        //Diamond
        EntityModelLayerRegistry.registerModelLayer(diamond_shield_model_layer, ShieldEntityModel::getTexturedModelData);

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier(BasicShields.MOD_ID, "entity/diamond_shield_base"));
            registry.register(new Identifier(BasicShields.MOD_ID, "entity/diamond_shield_base_nopattern"));
        });

        //Netherite
        EntityModelLayerRegistry.registerModelLayer(netherite_shield_model_layer, ShieldEntityModel::getTexturedModelData);

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier(BasicShields.MOD_ID, "entity/netherite_shield_base"));
            registry.register(new Identifier(BasicShields.MOD_ID, "entity/netherite_shield_base_nopattern"));
        });

        /**
         * MOD INTEGRATION STUFF HERE
         */
        if(FabricLoader.getInstance().isModLoaded("techreborn")) {

            //Bronze
            EntityModelLayerRegistry.registerModelLayer(bronze_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/bronze_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/bronze_shield_base_nopattern"));
            });

            //Ruby
            EntityModelLayerRegistry.registerModelLayer(ruby_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/ruby_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/ruby_shield_base_nopattern"));
            });

            //Peridot
            EntityModelLayerRegistry.registerModelLayer(peridot_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/peridot_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/peridot_shield_base_nopattern"));
            });

            //Sapphire
            EntityModelLayerRegistry.registerModelLayer(sapphire_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/sapphire_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/sapphire_shield_base_nopattern"));
            });
		}
    }
}
