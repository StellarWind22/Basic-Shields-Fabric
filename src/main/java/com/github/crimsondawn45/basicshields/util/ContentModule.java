package com.github.crimsondawn45.basicshields.util;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import net.fabricmc.loader.api.FabricLoader;

public class ContentModule {

    public static List<ContentModule> loadedModules = new ArrayList<ContentModule>();

    private List<ModRecipe> recipes = new ArrayList<ModRecipe>();
    private boolean isLoaded = false;
    private boolean forceLoaded = false;

    /**
     * @param forceLoad whether or not to ignore requried modId's
     * @param requiredIds list of modId's that any being detected will load module.
     */
    public ContentModule(boolean forceLoad, String...ids) {

        //Check the id
        for(String id : ids) {
            if(FabricLoader.getInstance().isModLoaded(id)) {
                this.isLoaded = true;
            }
        }

        //If always load is true force module to load if it isn't
        if(forceLoad && !this.isLoaded) {
            this.isLoaded = true;
            this.forceLoaded = true;
        }

        if(this.isLoaded) {
            registerContent();
            ContentModule.loadedModules.add(this);
        }
    }

    public ContentModule(boolean forceLoad, boolean isVanillaMaterial, String...ids) {

        //Check the id
        for(String id : ids) {
            if(FabricLoader.getInstance().isModLoaded(id)) {
                this.isLoaded = true;
            }
        }

        /**
         * If module is set to always load & isn't loaded then make it load
         * If module is a vanilla material do not mark it as force loaded(enables crafting)
         */
        if(forceLoad && !this.isLoaded) {
            this.isLoaded = true;

            if(!isVanillaMaterial) {
                this.forceLoaded = true;
            }
        }

        if(this.isLoaded) {
            registerContent();
            ContentModule.loadedModules.add(this);
        }
    }
    
    public ContentModule() {
        this.forceLoaded = false;
        this.isLoaded = true;
        registerContent();
        ContentModule.loadedModules.add(this);
    }

    public boolean isLoaded() {
       return this.isLoaded;
    }

    /**
     * Tells you whether or not a module has been force loaded. If a module was configured to force load
     * but was already loaded it will return false.
     */
    public boolean isForceLoaded() {
        return this.forceLoaded;
    }

    /**
     * * meant to be overwritten this is the method you use for registering any and all content a module may contain.
     * 
     * @author CrimsonDawn45
     */
    public void registerContent(){}

    /**
     * Registers crafting recipes for module
     */
    public void addRecipe(ModItem item, JsonObject recipe) {
        this.recipes.add(new ModRecipe(item, recipe));
    }

    /**
     * Return unmutable array of loaded recipes
     */
    public ModRecipe[] getRecipes() {
        return this.recipes.stream().toArray(ModRecipe[]::new);
    }
}
