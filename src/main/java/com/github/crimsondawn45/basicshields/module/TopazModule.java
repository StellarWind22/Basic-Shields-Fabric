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

public class TopazModule extends ContentModule {

    //Bronze Stuff
    public ModItem topaz_shield;
    public JsonObject topaz_shield_recipe;

    //Tag
    public Identified<Item> topaz_tag;

    public TopazModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        topaz_tag = TagFactory.ITEM.create(new Identifier("c","topazes"));

        //Item
        topaz_shield = new ModItem("topaz_shield",
        new BasicShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.topaz_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.topaz_shield_cooldown,
        BasicShields.CONFIG.topaz_shield_enchantability,
        topaz_tag));

        //Recipe
        topaz_shield_recipe = RecipeHelper.createShieldRecipe(topaz_tag.getId(), true, topaz_shield.getIdentifier());
    }
    
}
