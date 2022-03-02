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
import net.minecraft.tag.Tag.Identified;
import net.minecraft.util.Identifier;

public class ObsidianModule extends ContentModule {

    //Obsidian Stuff
    public ModItem obsidian_shield;
    public JsonObject obsidian_shield_recipe;

    //Tag
    public Identified<Item> obsidian_tag;

    public ObsidianModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        obsidian_tag = TagFactory.ITEM.create(new Identifier("c","obsidian_ingots"));

        //Item
        obsidian_shield = new ModItem("obsidian_shield",
        new BasicShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.obsidian_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.obsidian_shield_cooldown,
        BasicShields.CONFIG.obsidian_shield_enchantability,
        obsidian_tag));

        //Recipe
        obsidian_shield_recipe = RecipeHelper.createShieldRecipe(obsidian_tag.getId(), true, obsidian_shield.getIdentifier());
    }
}
