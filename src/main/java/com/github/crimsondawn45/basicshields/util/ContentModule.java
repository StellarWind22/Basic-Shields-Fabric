package com.github.crimsondawn45.basicshields.util;

import net.fabricmc.loader.api.FabricLoader;

public class ContentModule {

    private boolean isLoaded;
    private boolean isForceLoaded;

    /**
     * @param alwaysLoad whether or not to ignore requried modId's
     * @param requiredIds list of modId's that any being detected will load module.
     */
    public ContentModule(boolean alwaysLoad, String...ids) {
        this.isForceLoaded = alwaysLoad;

        //If module is force enabled don't bother checking loaded mods
        if(alwaysLoad) {
            this.isLoaded = true;

        } else {

            //Check the id
            for(String id : ids) {
                if(FabricLoader.getInstance().isModLoaded(id)) {
                    this.isLoaded = true;
                }
            }
        }

        if(this.isLoaded) {
            registerContent();
        }
    }
    
    public ContentModule() {
        this.isLoaded = true;
        registerContent();
    }

    public boolean isLoaded() {
       return this.isLoaded;
    }

    public boolean isForceLoaded() {
        this.isForceLoaded = false;
        return this.isForceLoaded;
    }

    /**
     * * meant to be overwritten this is the method you use for registering any and all content a module may contain.
     * 
     * @author CrimsonDawn45
     */
    public void registerContent(){}
}
