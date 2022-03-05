package com.github.crimsondawn45.basicshields.util;

import net.fabricmc.loader.api.FabricLoader;

public class ModRef {
    
    private String modId;
    private String texturePath;
    private boolean isLoaded;

    public ModRef(String modId, String texturePath) {
        this.modId = modId.trim();
        this.texturePath = texturePath.trim();
        this.isLoaded = FabricLoader.getInstance().isModLoaded(this.getModId());
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
