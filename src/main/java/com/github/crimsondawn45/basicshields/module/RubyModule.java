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

public class RubyModule extends ContentModule {

    //Ruby Stuff
    public ModItem ruby_shield;
    public JsonObject ruby_shield_recipe;

    //Ruby tag
    public ArrayList<Identified<Item>> ruby_tag_list;

    public RubyModule(String...requiredIds) {
        super(requiredIds);
    }

    @Override
    public void registerContent() {

        //Tag
        ruby_tag_list = Lists.newArrayList(
            TagFactory.ITEM.create(new Identifier("c","rubies"))
        );
        
        //Item
        ruby_shield = new ModItem("ruby_shield", new BasicShieldItem(new FabricItemSettings().maxDamage(1008).group(BasicShields.SHIELDS), 90, 10, ruby_tag_list));

        //Recipe
        ruby_shield_recipe = RecipeHelper.createShieldRecipe(ruby_tag_list, ruby_shield.getIdentifier());
    }
}