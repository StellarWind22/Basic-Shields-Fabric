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

public class CarbonadoModule extends ContentModule {

    //Bronze Stuff
    public ModItem carbonado_shield;
    public JsonObject carbonado_shield_recipe;

    //Tag
    public TagKey<Item> carbonado_tag;

    public CarbonadoModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        carbonado_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "carbonado"));

        //Item
        carbonado_shield = new ModItem("carbonado_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.carbonado_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.carbonado_shield_cooldown,
        BasicShields.CONFIG.carbonado_shield_enchantability,
        carbonado_tag));

        //Recipe
        carbonado_shield_recipe = RecipeHelper.createShieldRecipe(carbonado_tag.id(), true, carbonado_shield.getIdentifier());
    }
    
}
