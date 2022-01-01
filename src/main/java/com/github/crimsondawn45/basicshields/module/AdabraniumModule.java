package com.github.crimsondawn45.basicshields.module;

import com.brand.adabraniummod.content.ModItems;
import com.github.crimsondawn45.basicshields.initializer.BasicShields;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import com.github.crimsondawn45.util.ContentModule;
import com.github.crimsondawn45.util.ModItem;
import com.github.crimsondawn45.util.RecipeHelper;
import com.google.gson.JsonObject;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.util.Identifier;

public class AdabraniumModule extends ContentModule {

    //Adabranium Items
    public ModItem adamantium_shield;
    public ModItem vibranium_shield;
    public ModItem nether_shield;
        //Adabranium recipes
    public JsonObject adamantium_shield_recipe;
    public JsonObject vibranium_shield_recipe;
    public JsonObject nether_shield_recipe;

    public AdabraniumModule(String...requiredIds) {
        super(requiredIds);
    }

    //TODO: finish!

    @Override
    public void registerContent() {
        
        //Adamantium
        adamantium_shield = new ModItem("adamantium_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(504).group(BasicShields.SHIELDS), 100, 6, ModItems.ADAMANTIUM_INGOT));
        adamantium_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("c", "adamantium_ingots"), true, adamantium_shield.getIdentifier());

        //Vibranium

        //Nether
    }
}
