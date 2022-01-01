package com.github.crimsondawn45.basicshields.mixin;

import java.util.Map;

import com.github.crimsondawn45.basicshields.BasicShields;
import com.github.crimsondawn45.basicshields.registry.ModItems;
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

        //Vanilla
        map.put(new Identifier(BasicShields.MOD_ID, ModItems.wooden_shield.getName()), ModItems.wooden_shield_recipe);
        map.put(new Identifier(BasicShields.MOD_ID, ModItems.golden_shield.getName()), ModItems.golden_shield_recipe);
        map.put(new Identifier(BasicShields.MOD_ID, ModItems.diamond_shield.getName()), ModItems.diamond_shield_recipe);
        //map.put(new Identifier(BasicShields.MOD_ID, ModItems.netherite_shield.getName()), ModItems.netherite_shield_recipe);

        //Tech Reborn
        if(BasicShields.isLoaded("techreborn")) {
            map.put(new Identifier(BasicShields.MOD_ID, ModItems.bronze_shield.getName()), ModItems.bronze_shield_recipe);
            map.put(new Identifier(BasicShields.MOD_ID, ModItems.ruby_shield.getName()), ModItems.ruby_shield_recipe);
            map.put(new Identifier(BasicShields.MOD_ID, ModItems.peridot_shield.getName()), ModItems.peridot_shield_recipe);
            map.put(new Identifier(BasicShields.MOD_ID, ModItems.sapphire_shield.getName()), ModItems.sapphire_shield_recipe);
		}
    }
}