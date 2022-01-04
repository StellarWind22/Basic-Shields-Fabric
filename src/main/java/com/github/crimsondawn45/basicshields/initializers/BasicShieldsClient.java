package com.github.crimsondawn45.basicshields.initializers;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.Identifier;

public class BasicShieldsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        /**
         * Vanilla
         */
        if(BasicShields.vanilla.isLoaded()) {

            //Wooden
            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/wooden_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/wooden_shield_base_nopattern"));
            });

            //Golden
            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/golden_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/golden_shield_base_nopattern"));
            });

            //Diamond
            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/diamond_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/diamond_shield_base_nopattern"));
            });

            //Netherite
            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/netherite_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/netherite_shield_base_nopattern"));
            });
        }

        /**
         * Techreborn
         */
        if(BasicShields.techReborn.isLoaded()) {

            //Bronze
            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/bronze_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/bronze_shield_base_nopattern"));
            });

            //Ruby
            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/ruby_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/ruby_shield_base_nopattern"));
            });

            //Peridot
            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/peridot_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/peridot_shield_base_nopattern"));
            });

            //Sapphire
            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/sapphire_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/sapphire_shield_base_nopattern"));
            });
		}

        /**
         * Adabranium
         */
        if(BasicShields.adabranium.isLoaded()) {

            //Nether
            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/nether_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/nether_shield_base_nopattern"));
            });

            //Vibranium
            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/vibranium_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/vibranium_shield_base_nopattern"));
            });

            //Adamantium
            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/adamantium_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/adamantium_shield_base_nopattern"));
            });

        }


        /**
         * Gobber
         */
        if(BasicShields.gobber.isLoaded()) {

            //Gobber
            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/gobber_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/gobber_shield_base_nopattern"));
            });

            //Gobber Nether
            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/gobber_nether_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/gobber_nether_shield_base_nopattern"));
            });

            //Gobber End
            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/gobber_end_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/gobber_end_shield_base_nopattern"));
            });

            //Gobber Dragon
            ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/gobber_dragon_shield_base"));
                registry.register(new Identifier(BasicShields.MOD_ID, "entity/gobber_dragon_shield_base_nopattern"));
            });
        }
    }
}