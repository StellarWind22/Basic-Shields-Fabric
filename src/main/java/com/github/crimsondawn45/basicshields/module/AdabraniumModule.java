package com.github.crimsondawn45.basicshields.module;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.basicshields.object.BasicShieldItem;
import com.github.crimsondawn45.basicshields.util.ContentModule;
import com.github.crimsondawn45.basicshields.util.ModItem;
import com.github.crimsondawn45.basicshields.util.RecipeHelper;
import com.google.gson.JsonObject;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tag.Tag.Identified;
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

    //Tags
    public Identified<Item> vibranium_tag;
    public Identified<Item> adamantium_tag;

    public AdabraniumModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tags
        vibranium_tag = TagFactory.ITEM.create(new Identifier("c","adabranium_vibranium_ingots"));
        adamantium_tag = TagFactory.ITEM.create(new Identifier("c","adabranium_adamantium_ingots"));
        
        //Nether
        nether_shield = new ModItem("nether_shield",
            new BasicShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.adabranium_nether_shield_durability).group(BasicShields.SHIELDS).fireproof(),
            BasicShields.CONFIG.adabranium_nether_shield_cooldown,
            BasicShields.CONFIG.adabranium_nether_shield_enchantability,
            Items.NETHER_BRICK));
        nether_shield_recipe = RecipeHelper.createSmithingRecipe(new Identifier("minecraft", "shield"), false, new Identifier("minecraft", "nether_brick"), false, nether_shield.getIdentifier());
       
        //Vibranium
        vibranium_shield = new ModItem("vibranium_shield",
            new BasicShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.adabranium_vibranium_shield_durability).group(BasicShields.SHIELDS),
            BasicShields.CONFIG.adabranium_vibranium_shield_cooldown,
            BasicShields.CONFIG.adabranium_vibranium_shield_enchantability,
            vibranium_tag));
        vibranium_shield_recipe = RecipeHelper.createShieldRecipe(vibranium_tag.getId(), true, vibranium_shield.getIdentifier());

        //Adamantium
        adamantium_shield = new ModItem("adamantium_shield",
            new BasicShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.adabranium_adamantium_shield_durability).group(BasicShields.SHIELDS),
            BasicShields.CONFIG.adabranium_adamantium_shield_cooldown,
            BasicShields.CONFIG.adabranium_adamantium_shield_enchantability,
            adamantium_tag));
        adamantium_shield_recipe = RecipeHelper.createShieldRecipe(adamantium_tag.getId(), true, adamantium_shield.getIdentifier());
    }
}