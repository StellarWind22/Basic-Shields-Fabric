package com.github.crimsondawn45.basicshields.mixin;

import java.util.Map;

import com.github.crimsondawn45.basicshields.BasicShields;
import com.github.crimsondawn45.basicshields.registry.ModItems;
import com.google.gson.JsonObject;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;

@Mixin(RecipeManager.class)
public class RecipeManagerMixin {
    
    @Inject(at = @At("HEAD"), method = "apply")
    public void interceptApply(Map<Identifier, JsonObject> map, ResourceManager resourceManager, Profiler profiler, CallbackInfo info) {
        if(FabricLoader.getInstance().isModLoaded("techreborn")) {
            map.put(new Identifier(BasicShields.MOD_ID, ModItems.bronze_shield.getName()), ModItems.bronze_shield_recipe);
            map.put(new Identifier(BasicShields.MOD_ID, ModItems.ruby_shield.getName()), ModItems.ruby_shield_recipe);
            map.put(new Identifier(BasicShields.MOD_ID, ModItems.peridot_shield.getName()), ModItems.peridot_shield_recipe);
            map.put(new Identifier(BasicShields.MOD_ID, ModItems.sapphire_shield.getName()), ModItems.sapphire_shield_recipe);
		}
    }
}