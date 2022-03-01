package com.github.crimsondawn45.basicshields.module;

import java.util.ArrayList;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.basicshields.object.BasicShieldItem;
import com.github.crimsondawn45.basicshields.util.ContentModule;
import com.github.crimsondawn45.basicshields.util.ModItem;
import com.github.crimsondawn45.basicshields.util.RecipeHelper;
import com.google.common.collect.Lists;
import com.google.gson.JsonObject;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag.Identified;
import net.minecraft.util.Identifier;

public class BronzeModule extends ContentModule {

    //Bronze Stuff
    public ModItem bronze_shield;
    public JsonObject bronze_shield_recipe;

    //Tag
    public ArrayList<Identified<Item>> bronze_tag_list;

    public BronzeModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        bronze_tag_list = Lists.newArrayList(
            TagFactory.ITEM.create(new Identifier("c","bronze_ingots"))
        );

        //Item
        bronze_shield = new ModItem("bronze_shield",
        new BasicShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.bronze_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.bronze_shield_cooldown,
        BasicShields.CONFIG.bronze_shield_enchantability,
        bronze_tag_list));

        //Recipe
        bronze_shield_recipe = RecipeHelper.createShieldRecipe(bronze_tag_list, bronze_shield.getIdentifier());
    }
}
