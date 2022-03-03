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

public class QuartzModule extends ContentModule {

    //Quartz Stuff
    public ModItem quartz_shield;
    public JsonObject quartz_shield_recipe;

    //Tag
    public TagKey<Item> quartz_tag;

    public QuartzModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        quartz_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c","quartz"));

        //Item
        quartz_shield = new ModItem("quartz_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.quartz_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.quartz_shield_cooldown,
        BasicShields.CONFIG.quartz_shield_enchantability,
        quartz_tag));

        //Recipe
        quartz_shield_recipe = RecipeHelper.createShieldRecipe(quartz_tag.id(), true, quartz_shield.getIdentifier());
    }
}
