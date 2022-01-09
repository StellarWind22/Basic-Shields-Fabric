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

public class SapphireModule extends ContentModule {

    //Peridot Stuff
    public ModItem sapphire_shield;
    public JsonObject sapphire_shield_recipe;

    //Peridot tag
    public ArrayList<Identified<Item>> sapphire_tag_list;

    public SapphireModule(String...requiredIds) {
        super(requiredIds);
    }
 
    @Override
    public void registerContent() {
 
        //Tag
        sapphire_tag_list = Lists.newArrayList(
            TagFactory.ITEM.create(new Identifier("c","sapphires")),
            TagFactory.ITEM.create(new Identifier("c","sapphire")),
            TagFactory.ITEM.create(new Identifier("c","sapphire_gem"))
        );

        //Item
        sapphire_shield = new ModItem("sapphire_shield", new BasicShieldItem(new FabricItemSettings().maxDamage(1344).group(BasicShields.SHIELDS), 90, 12, sapphire_tag_list));

        //Recipe
        sapphire_shield_recipe = RecipeHelper.createShieldRecipe(sapphire_tag_list, sapphire_shield.getIdentifier());
    }
}