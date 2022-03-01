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

public class KunziteModule extends ContentModule {

    //Bronze Stuff
    public ModItem kunzite_shield;
    public JsonObject kunzite_shield_recipe;

    //Tag
    public Identified<Item> kunzite_tag;

    public KunziteModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        kunzite_tag = TagFactory.ITEM.create(new Identifier("c","kunzites"));

        //Item
        kunzite_shield = new ModItem("kunzite_shield",
        new BasicShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.kunzite_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.kunzite_shield_cooldown,
        BasicShields.CONFIG.kunzite_shield_enchantability,
        kunzite_tag));

        //Recipe
        kunzite_shield_recipe = RecipeHelper.createShieldRecipe(kunzite_tag.getId(), true, kunzite_shield.getIdentifier());
    }
    
}
