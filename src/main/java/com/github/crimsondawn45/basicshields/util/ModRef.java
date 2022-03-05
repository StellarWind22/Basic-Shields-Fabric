package com.github.crimsondawn45.basicshields.util;

import net.fabricmc.loader.api.FabricLoader;

public class ModRef {
    
    private String modId;
    private String texturePath;
    private boolean isLoaded;

    public ModRef(String modId, String texturePath) {
        this.modId = modId;
        this.texturePath = texturePath;
        this.isLoaded = FabricLoader.getInstance().isModLoaded(modId);
    }

    public String getModId() {
        return this.modId;
    }

    public String getTexturePath() {
        return this.texturePath;
    }

    public boolean isLoaded() {
        return this.isLoaded;
    }
}
