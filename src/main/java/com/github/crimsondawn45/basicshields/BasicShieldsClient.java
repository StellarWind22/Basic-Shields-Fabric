package com.github.crimsondawn45.basicshields;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.Identifier;

public class BasicShieldsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        //Wooden
        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEX).register((atlasTexture, registry) -> {
            registry.register(new Identifier(BasicShields.MOD_ID, "entity/wooden_shield_base"));
            registry.register(new Identifier(BasicShields.MOD_ID, "entity/wooden_shield_base_nopattern"));
        });

        //Golden
        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEX).register((atlasTexture, registry) -> {
            registry.register(new Identifier(BasicShields.MOD_ID, "entity/golden_shield_base"));
            registry.register(new Identifier(BasicShields.MOD_ID, "entity/golden_shield_base_nopattern"));
        });

        //Diamond
        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEX).register((atlasTexture, registry) -> {
            registry.register(new Identifier(BasicShields.MOD_ID, "entity/diamond_shield_base"));
            registry.register(new Identifier(BasicShields.MOD_ID, "entity/diamond_shield_base_nopattern"));
        });

        //Netherite
        /*
        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier(BasicShields.MOD_ID, "entity/netherite_shield_base"));
            registry.register(new Identifier(BasicShields.MOD_ID, "entity/netherite_shield_base_nopattern"));
        });
        */
    }
}
