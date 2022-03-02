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

public class EmeraldModule extends ContentModule {

    //Emerald Stuff
    public ModItem emerald_shield;
    public JsonObject emerald_shield_recipe;

    //Tag
    public Identified<Item> emerald_tag;

    public EmeraldModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        emerald_tag = TagFactory.ITEM.create(new Identifier("c","emerald_ingots"));

        //Item
        emerald_shield = new ModItem("emerald_shield",
        new BasicShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.emerald_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.emerald_shield_cooldown,
        BasicShields.CONFIG.emerald_shield_enchantability,
        emerald_tag));

        //Recipe
        emerald_shield_recipe = RecipeHelper.createShieldRecipe(emerald_tag.getId(), true, emerald_shield.getIdentifier());
    }
}
