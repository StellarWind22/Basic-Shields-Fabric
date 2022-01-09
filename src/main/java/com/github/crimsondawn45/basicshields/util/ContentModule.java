package com.github.crimsondawn45.basicshields.util;

import net.fabricmc.loader.api.FabricLoader;

public class ContentModule {

    private boolean isLoaded;

    /**
     * * modules without arguments are always loaded.
     * 
     * @param requiredIds list of modId's that any being detected will load module.
     */
    public ContentModule(String...ids) {

        //Check the id
        for(String id : ids) {
            if(FabricLoader.getInstance().isModLoaded(id)) {
                this.isLoaded = true;
            }
        }

        if(this.isLoaded) {
            registerContent();
        }
    }

    /**
     * * modules without arguments are always loaded.
     */
    public ContentModule() {
        this.isLoaded = true;
        registerContent();
    }

    public boolean isLoaded() {
       return this.isLoaded;
    }

    /**
     * * meant to be overwritten this is the method you use for registering any and all content a module may contain.
     * 
     * @author CrimsonDawn45
     */
    public void registerContent(){}
}
