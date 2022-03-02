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

public class AmethystModule extends ContentModule {

    //Amethyst Stuff
    public ModItem amethyst_shield;
    public JsonObject amethyst_shield_recipe;

    //Tag
    public Identified<Item> amethyst_tag;

    public AmethystModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        amethyst_tag = TagFactory.ITEM.create(new Identifier("c","amethyst_ingots"));

        //Item
        amethyst_shield = new ModItem("amethyst_shield",
        new BasicShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.amethyst_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.amethyst_shield_cooldown,
        BasicShields.CONFIG.amethyst_shield_enchantability,
        amethyst_tag));

        //Recipe
        amethyst_shield_recipe = RecipeHelper.createShieldRecipe(amethyst_tag.getId(), true, amethyst_shield.getIdentifier());
    }
}
