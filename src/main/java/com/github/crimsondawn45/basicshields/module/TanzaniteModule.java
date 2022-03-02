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

public class TanzaniteModule extends ContentModule {

    //Bronze Stuff
    public ModItem tanzanite_shield;
    public JsonObject tanzanite_shield_recipe;

    //Tag
    public Identified<Item> tanzanite_tag;

    public TanzaniteModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        tanzanite_tag = TagFactory.ITEM.create(new Identifier("c","tanzanites"));

        //Item
        tanzanite_shield = new ModItem("tanzanite_shield",
        new BasicShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.tanzanite_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.tanzanite_shield_cooldown,
        BasicShields.CONFIG.tanzanite_shield_enchantability,
        tanzanite_tag));

        //Recipe
        tanzanite_shield_recipe = RecipeHelper.createShieldRecipe(tanzanite_tag.getId(), true, tanzanite_shield.getIdentifier());
    }
    
}
