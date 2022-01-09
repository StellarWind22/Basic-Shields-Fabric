package com.github.crimsondawn45.basicshields.util;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;

import net.minecraft.tag.Tag.Identified;

public class ContentModule {

    private boolean isLoaded;

    /**
     * * modules without arguments are always loaded.
     * 
     * @param requiredIds list of modId's that any being detected will load module.
     */
    public ContentModule(String...requiredIds) {

        //Check the id's
        for(String id : requiredIds) {

            if(BasicShields.isLoaded(id)) { //If any detected load module

                this.isLoaded = true;
                break;
            }
        }

        if(this.isLoaded) {
            registerContent();
        }
    }

    /**
     * * modules without arguments are always loaded.
     * 
     * @param requiredTag tag that must contain at least one object to load.
     */
    public ContentModule(Identified<Object> requiredTag) {
        this.isLoaded = !requiredTag.values().isEmpty();

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
