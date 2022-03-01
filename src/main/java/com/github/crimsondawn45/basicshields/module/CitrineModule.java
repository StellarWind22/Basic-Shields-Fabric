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

public class CitrineModule extends ContentModule {

    //Bronze Stuff
    public ModItem citrine_shield;
    public JsonObject citrine_shield_recipe;

    //Tag
    public ArrayList<Identified<Item>> citrine_tag_list;

    public CitrineModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        citrine_tag_list = Lists.newArrayList(
            TagFactory.ITEM.create(new Identifier("c","citrine"))
        );

        //Item
        citrine_shield = new ModItem("citrine_shield", new BasicShieldItem(new FabricItemSettings().maxDamage(504).group(BasicShields.SHIELDS), 100, 6, citrine_tag_list));

        //Recipe
        citrine_shield_recipe = RecipeHelper.createShieldRecipe(citrine_tag_list, citrine_shield.getIdentifier());
    }
    
}
