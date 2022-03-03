package com.github.crimsondawn45.basicshields.module;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.basicshields.util.ContentModule;
import com.github.crimsondawn45.basicshields.util.ModItem;
import com.github.crimsondawn45.basicshields.util.RecipeHelper;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import com.google.gson.JsonObject;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BronzeModule extends ContentModule {

    //Bronze Stuff
    public ModItem bronze_shield;
    public JsonObject bronze_shield_recipe;

    //Tag
    public TagKey<Item> bronze_tag;

    public BronzeModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        bronze_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "bronze_ingots"));

        //Item
        bronze_shield = new ModItem("bronze_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.bronze_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.bronze_shield_cooldown,
        BasicShields.CONFIG.bronze_shield_enchantability,
        bronze_tag));

        //Recipe
        bronze_shield_recipe = RecipeHelper.createShieldRecipe(bronze_tag.id(), true, bronze_shield.getIdentifier());
    }
}
