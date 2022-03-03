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

public class EmeraldModule extends ContentModule {

    //Bronze Stuff
    public ModItem emerald_shield;
    public JsonObject emerald_shield_recipe;

    //Tag
    public TagKey<Item> emerald_tag;

    public EmeraldModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        emerald_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "emeralds"));

        //Item
        emerald_shield = new ModItem("emerald_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.emerald_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.emerald_shield_cooldown,
        BasicShields.CONFIG.emerald_shield_enchantability,
        emerald_tag));

        //Recipe
        emerald_shield_recipe = RecipeHelper.createShieldRecipe(emerald_tag.id(), true, emerald_shield.getIdentifier());
    }
}
