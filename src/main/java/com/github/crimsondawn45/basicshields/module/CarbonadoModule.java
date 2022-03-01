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

public class CarbonadoModule extends ContentModule {

    //Bronze Stuff
    public ModItem carbonado_shield;
    public JsonObject carbonado_shield_recipe;

    //Tag
    public Identified<Item> carbonado_tag;

    public CarbonadoModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        carbonado_tag = TagFactory.ITEM.create(new Identifier("c","carbonadoes"));

        //Item
        carbonado_shield = new ModItem("carbonado_shield",
        new BasicShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.carbonado_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.carbonado_shield_cooldown,
        BasicShields.CONFIG.carbonado_shield_enchantability,
        carbonado_tag));

        //Recipe
        carbonado_shield_recipe = RecipeHelper.createShieldRecipe(carbonado_tag.getId(), true, carbonado_shield.getIdentifier());
    }
    
}
