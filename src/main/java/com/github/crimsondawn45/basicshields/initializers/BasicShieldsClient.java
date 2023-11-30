package com.github.crimsondawn45.basicshields.initializers;

import com.github.crimsondawn45.basicshields.util.ContentModule;
import com.github.crimsondawn45.basicshields.util.ModShieldItem;

import net.fabricmc.api.ClientModInitializer;

public class BasicShieldsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        for(ContentModule module : ContentModule.loadedModules) {

            for(ModShieldItem shield : module.getShieldItems()) {
                shield.clientShieldInit();
            }
        }
    }
}