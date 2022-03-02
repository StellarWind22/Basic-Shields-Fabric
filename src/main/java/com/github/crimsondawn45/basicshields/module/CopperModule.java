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

public class CopperModule extends ContentModule {

    //Copper Stuff
    public ModItem copper_shield;
    public JsonObject copper_shield_recipe;

    //Tag
    public Identified<Item> copper_tag;

    public CopperModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        copper_tag = TagFactory.ITEM.create(new Identifier("c","copper_ingots"));

        //Item
        copper_shield = new ModItem("copper_shield",
        new BasicShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.copper_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.copper_shield_cooldown,
        BasicShields.CONFIG.copper_shield_enchantability,
        copper_tag));

        //Recipe
        copper_shield_recipe = RecipeHelper.createShieldRecipe(copper_tag.getId(), true, copper_shield.getIdentifier());
    }
}
