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

public class SpinelModule extends ContentModule {

    //Bronze Stuff
    public ModItem spinel_shield;
    public JsonObject spinel_shield_recipe;

    //Tag
    public Identified<Item> spinel_tag;

    public SpinelModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        spinel_tag = TagFactory.ITEM.create(new Identifier("c","spinels"));

        //Item
        spinel_shield = new ModItem("spinel_shield",
        new BasicShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.spinel_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.spinel_shield_cooldown,
        BasicShields.CONFIG.spinel_shield_enchantability,
        spinel_tag));

        //Recipe
        spinel_shield_recipe = RecipeHelper.createShieldRecipe(spinel_tag.getId(), true, spinel_shield.getIdentifier());
    }
    
}
