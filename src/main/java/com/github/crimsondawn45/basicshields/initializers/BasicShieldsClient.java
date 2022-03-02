package com.github.crimsondawn45.basicshields.initializers;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
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
    //Adabranium
    public static final EntityModelLayer nether_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "nether_shield"),"main");
    public static final EntityModelLayer vibranium_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "vibranium_shield"),"main");
    public static final EntityModelLayer adamantium_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "adamantium_shield"),"main");
    //Alexandrite
    public static final EntityModelLayer alexandrite_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "alexandrite_shield"),"main");
    //Bronze
    public static final EntityModelLayer bronze_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "bronze_shield"),"main");
    //Carbonado
    public static final EntityModelLayer carbonado_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "carbonado_shield"),"main");
    //Citrine
    public static final EntityModelLayer citrine_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "citrine_shield"),"main");
    //Corundum
    public static final EntityModelLayer corundum_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "corundum_shield"),"main");
    //Gobber
    public static final EntityModelLayer gobber_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "gobber_shield"),"main");
    public static final EntityModelLayer gobber_nether_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "gobber_nether_shield"),"main");
    public static final EntityModelLayer gobber_end_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "gobber_end_shield"),"main");
    public static final EntityModelLayer gobber_dragon_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "gobber_dragon_shield"),"main");
    //Kunzite
    public static final EntityModelLayer kunzite_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "kunzite_shield"),"main");
    //Moissanite
    public static final EntityModelLayer moissanite_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "moissanite_shield"),"main");
    //Peridot
    public static final EntityModelLayer peridot_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "peridot_shield"),"main");
    //Ruby
    public static final EntityModelLayer ruby_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "ruby_shield"),"main");
    //Sapphire
    public static final EntityModelLayer sapphire_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "sapphire_shield"),"main");
    //Spinel
    public static final EntityModelLayer spinel_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "spinel_shield"),"main");
    //Topaz
    public static final EntityModelLayer topaz_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "topaz_shield"),"main");
    //Tourmaline
    public static final EntityModelLayer tourmaline_shield_model_layer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, "tourmaline_shield"),"main");

    @Override
    public void onInitializeClient() {

        /**
         * Vanilla
         */
        if(BasicShields.vanilla.isLoaded()) {

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
        }

        /**
         * Adabranium
         */
        if(BasicShields.adabranium.isLoaded()) {

            //Nether
            EntityModelLayerRegistry.registerModelLayer(nether_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/nether_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/nether_shield_base_nopattern"));
            });

            //Vibranium
            EntityModelLayerRegistry.registerModelLayer(vibranium_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/vibranium_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/vibranium_shield_base_nopattern"));
            });

            //Adamantium
            EntityModelLayerRegistry.registerModelLayer(adamantium_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/adamantium_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/adamantium_shield_base_nopattern"));
            });

        }

        /**
         * Alexandrite
         */
        if(BasicShields.alexandrite.isLoaded()) {

            //Alexandrite
            EntityModelLayerRegistry.registerModelLayer(alexandrite_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/alexandrite_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/alexandrite_shield_base_nopattern"));
            });
		}

        /**
         * Bronze
         */
        if(BasicShields.bronze.isLoaded()) {

            //Bronze
            EntityModelLayerRegistry.registerModelLayer(bronze_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/bronze_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/bronze_shield_base_nopattern"));
            });
		}

        /**
         * Ruby
         */
        if(BasicShields.ruby.isLoaded()) {

            //Ruby
            EntityModelLayerRegistry.registerModelLayer(ruby_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/ruby_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/ruby_shield_base_nopattern"));
            });
        }

        /**
         * Peridot
         */
        if(BasicShields.peridot.isLoaded()) {

            //Peridot
            EntityModelLayerRegistry.registerModelLayer(peridot_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/peridot_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/peridot_shield_base_nopattern"));
            });
        }

        /**
         * Sapphire
         */
        if(BasicShields.sapphire.isLoaded()) {

            //Sapphire
            EntityModelLayerRegistry.registerModelLayer(sapphire_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/sapphire_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/sapphire_shield_base_nopattern"));
            });
        }

        /**
         * Carbonado
         */
        if(BasicShields.carbonado.isLoaded()) {

            //Carbonado
            EntityModelLayerRegistry.registerModelLayer(carbonado_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/carbonado_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/carbonado_shield_base_nopattern"));
            });
		}

        /**
         * Citrine
         */
        if(BasicShields.citrine.isLoaded()) {

            //Citrine
            EntityModelLayerRegistry.registerModelLayer(citrine_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/citrine_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/citrine_shield_base_nopattern"));
            });
		}

        /**
         * Corundum
         */
        if(BasicShields.corundum.isLoaded()) {

            //Corundum
            EntityModelLayerRegistry.registerModelLayer(corundum_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/corundum_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/corundum_shield_base_nopattern"));
            });
		}

        /**
         * Gobber
         */
        if(BasicShields.gobber.isLoaded()) {

            //Gobber
            EntityModelLayerRegistry.registerModelLayer(gobber_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/gobber_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/gobber_shield_base_nopattern"));
            });

            //Gobber Nether
            EntityModelLayerRegistry.registerModelLayer(gobber_nether_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/gobber_nether_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/gobber_nether_shield_base_nopattern"));
            });

            //Gobber End
            EntityModelLayerRegistry.registerModelLayer(gobber_end_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/gobber_end_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/gobber_end_shield_base_nopattern"));
            });

            //Gobber Dragon
            EntityModelLayerRegistry.registerModelLayer(gobber_dragon_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/gobber_dragon_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/gobber_dragon_shield_base_nopattern"));
            });
        }

        /**
         * Kunzite
         */
        if(BasicShields.kunzite.isLoaded()) {

            //Kunzite
            EntityModelLayerRegistry.registerModelLayer(kunzite_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/kunzite_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/kunzite_shield_base_nopattern"));
            });
		}

        /**
         * Moissanite
         */
        if(BasicShields.moissanite.isLoaded()) {

            //Moissanite
            EntityModelLayerRegistry.registerModelLayer(moissanite_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/moissanite_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/moissanite_shield_base_nopattern"));
            });
		}

        /**
         * Spinel
         */
        if(BasicShields.spinel.isLoaded()) {

            //Spinel
            EntityModelLayerRegistry.registerModelLayer(spinel_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/spinel_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/spinel_shield_base_nopattern"));
            });
		}

        /**
         * Topaz
         */
        if(BasicShields.topaz.isLoaded()) {

            //Topaz
            EntityModelLayerRegistry.registerModelLayer(topaz_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/topaz_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/topaz_shield_base_nopattern"));
            });
		}

        /**
         * Tourmaline
         */
        if(BasicShields.tourmaline.isLoaded()) {

            //Tourmaline
            EntityModelLayerRegistry.registerModelLayer(tourmaline_shield_model_layer, ShieldEntityModel::getTexturedModelData);

            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/tourmaline_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/tourmaline_shield_base_nopattern"));
            });
		}
    }
}