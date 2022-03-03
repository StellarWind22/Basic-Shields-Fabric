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

public class AmethystModule extends ContentModule {

    //Bronze Stuff
    public ModItem amethyst_shield;
    public JsonObject amethyst_shield_recipe;

    //Tag
    public TagKey<Item> amethyst_tag;

    public AmethystModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        amethyst_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "amethyst"));

        //Item
        amethyst_shield = new ModItem("amethyst_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.amethyst_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.amethyst_shield_cooldown,
        BasicShields.CONFIG.amethyst_shield_enchantability,
        amethyst_tag));

        //Recipe
        amethyst_shield_recipe = RecipeHelper.createShieldRecipe(amethyst_tag.id(), true, amethyst_shield.getIdentifier());
    }
}
