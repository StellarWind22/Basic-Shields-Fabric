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

public class TanzaniteModule extends ContentModule {

    //Bronze Stuff
    public ModItem tanzanite_shield;
    public JsonObject tanzanite_shield_recipe;

    //Tag
    public TagKey<Item> tanzanite_tag;

    public TanzaniteModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        tanzanite_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c","tanzanites"));

        //Item
        tanzanite_shield = new ModItem("tanzanite_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.tanzanite_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.tanzanite_shield_cooldown,
        BasicShields.CONFIG.tanzanite_shield_enchantability,
        tanzanite_tag));

        //Recipe
        tanzanite_shield_recipe = RecipeHelper.createShieldRecipe(tanzanite_tag.id(), true, tanzanite_shield.getIdentifier());
    }
    
}
