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

public class SpinelModule extends ContentModule {

    //Bronze Stuff
    public ModItem spinel_shield;
    public JsonObject spinel_shield_recipe;

    //Tag
    public TagKey<Item> spinel_tag;

    public SpinelModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        spinel_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "spinel"));

        //Item
        spinel_shield = new ModItem("spinel_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.spinel_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.spinel_shield_cooldown,
        BasicShields.CONFIG.spinel_shield_enchantability,
        spinel_tag));

        //Recipe
        spinel_shield_recipe = RecipeHelper.createShieldRecipe(spinel_tag.id(), true, spinel_shield.getIdentifier());
    }
    
}
