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

public class QuartzModule extends ContentModule {

    //Quartz Stuff
    public ModItem quartz_shield;
    public JsonObject quartz_shield_recipe;

    //Tag
    public Identified<Item> quartz_tag;

    public QuartzModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        quartz_tag = TagFactory.ITEM.create(new Identifier("c","quartz_ingots"));

        //Item
        quartz_shield = new ModItem("quartz_shield",
        new BasicShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.quartz_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.quartz_shield_cooldown,
        BasicShields.CONFIG.quartz_shield_enchantability,
        quartz_tag));

        //Recipe
        quartz_shield_recipe = RecipeHelper.createShieldRecipe(quartz_tag.getId(), true, quartz_shield.getIdentifier());
    }
}
