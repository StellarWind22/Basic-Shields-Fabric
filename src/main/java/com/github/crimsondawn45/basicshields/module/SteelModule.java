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

public class SteelModule extends ContentModule {

    //Steel Stuff
    public ModItem steel_shield;
    public JsonObject steel_shield_recipe;

    //Tag
    public TagKey<Item> steel_tag;

    public SteelModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        steel_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c","steel_ingots"));

        //Item
        steel_shield = new ModItem("steel_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.steel_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.steel_shield_cooldown,
        BasicShields.CONFIG.steel_shield_enchantability,
        steel_tag));

        //Recipe
        steel_shield_recipe = RecipeHelper.createShieldRecipe(steel_tag.id(), true, steel_shield.getIdentifier());
    }
}
