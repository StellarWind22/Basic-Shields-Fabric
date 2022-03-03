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

public class CopperModule extends ContentModule {

    //Bronze Stuff
    public ModItem copper_shield;
    public JsonObject copper_shield_recipe;

    //Tag
    public TagKey<Item> copper_tag;

    public CopperModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        copper_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "copper_ingots"));

        //Item
        copper_shield = new ModItem("copper_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.copper_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.copper_shield_cooldown,
        BasicShields.CONFIG.copper_shield_enchantability,
        copper_tag));

        //Recipe
        copper_shield_recipe = RecipeHelper.createShieldRecipe(copper_tag.id(), true, copper_shield.getIdentifier());
    }
}
