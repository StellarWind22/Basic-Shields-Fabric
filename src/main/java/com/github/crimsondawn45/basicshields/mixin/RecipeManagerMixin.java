package com.github.crimsondawn45.basicshields.mixin;

import java.util.Map;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
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
        if(BasicShields.vanilla.isLoaded()) {
            map.put(new Identifier(BasicShields.MOD_ID, BasicShields.vanilla.wooden_shield.getName()), BasicShields.vanilla.wooden_shield_recipe);
            map.put(new Identifier(BasicShields.MOD_ID, BasicShields.vanilla.golden_shield.getName()), BasicShields.vanilla.golden_shield_recipe);
            map.put(new Identifier(BasicShields.MOD_ID, BasicShields.vanilla.diamond_shield.getName()), BasicShields.vanilla.diamond_shield_recipe);
            map.put(new Identifier(BasicShields.MOD_ID, BasicShields.vanilla.netherite_shield.getName()), BasicShields.vanilla.netherite_shield_recipe);
        }

        //Tech Reborn
        if(BasicShields.techReborn.isLoaded()) {
            map.put(new Identifier(BasicShields.MOD_ID, BasicShields.techReborn.bronze_shield.getName()), BasicShields.techReborn.bronze_shield_recipe);
            map.put(new Identifier(BasicShields.MOD_ID, BasicShields.techReborn.ruby_shield.getName()), BasicShields.techReborn.ruby_shield_recipe);
            map.put(new Identifier(BasicShields.MOD_ID, BasicShields.techReborn.peridot_shield.getName()), BasicShields.techReborn.peridot_shield_recipe);
            map.put(new Identifier(BasicShields.MOD_ID, BasicShields.techReborn.sapphire_shield.getName()), BasicShields.techReborn.sapphire_shield_recipe);
		}

        //Adabranium
        if(BasicShields.adabranium.isLoaded()) {
            map.put(new Identifier(BasicShields.MOD_ID, BasicShields.adabranium.adamantium_shield.getName()), BasicShields.adabranium.adamantium_shield_recipe);
            map.put(new Identifier(BasicShields.MOD_ID, BasicShields.adabranium.vibranium_shield.getName()), BasicShields.adabranium.vibranium_shield_recipe);
            map.put(new Identifier(BasicShields.MOD_ID, BasicShields.adabranium.nether_shield.getName()), BasicShields.adabranium.nether_shield_recipe);
        }

        //Gobber2
        if(BasicShields.gobber.isLoaded()) {
            map.put(new Identifier(BasicShields.MOD_ID, BasicShields.gobber.gobber_shield.getName()), BasicShields.gobber.gobber_shield_recipe);
            map.put(new Identifier(BasicShields.MOD_ID, BasicShields.gobber.gobber_nether_shield.getName()), BasicShields.gobber.gobber_nether_shield_recipe);
            map.put(new Identifier(BasicShields.MOD_ID, BasicShields.gobber.gobber_end_shield.getName()), BasicShields.gobber.gobber_end_shield_recipe);
        }
    }
}