package com.github.crimsondawn45.basicshields.mixin;

import java.util.Map;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.basicshields.util.ContentModule;
import com.github.crimsondawn45.basicshields.util.ModRecipe;
import com.google.gson.JsonElement;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.recipe.RecipeManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;

@Mixin(RecipeManager.class)
public class RecipeManagerMixin {
    
    @Inject(at = @At("HEAD"), method = "apply")
    public void interceptApply(Map<Identifier, JsonElement> map, ResourceManager resourceManager, Profiler profiler, CallbackInfo info) {

        /**
         * If a module is loaded and it is not force loaded then
         * auto-register all of it's recipes
         */
        for(ContentModule module : ContentModule.loadedModules) {

            if(!module.isForceLoaded()) {

                for(ModRecipe recipe : module.getRecipes()) {
                    map.put(new Identifier(BasicShields.MOD_ID, recipe.getModItem().getName()), recipe.getRecipe());
                }
            }
        }
    }
}