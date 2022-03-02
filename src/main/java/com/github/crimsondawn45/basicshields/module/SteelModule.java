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

public class SteelModule extends ContentModule {

    //Steel Stuff
    public ModItem steel_shield;
    public JsonObject steel_shield_recipe;

    //Tag
    public Identified<Item> steel_tag;

    public SteelModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        steel_tag = TagFactory.ITEM.create(new Identifier("c","steel_ingots"));

        //Item
        steel_shield = new ModItem("steel_shield",
        new BasicShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.steel_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.steel_shield_cooldown,
        BasicShields.CONFIG.steel_shield_enchantability,
        steel_tag));

        //Recipe
        steel_shield_recipe = RecipeHelper.createShieldRecipe(steel_tag.getId(), true, steel_shield.getIdentifier());
    }
}
