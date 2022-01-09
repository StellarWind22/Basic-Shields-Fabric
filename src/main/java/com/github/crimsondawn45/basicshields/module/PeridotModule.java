package com.github.crimsondawn45.basicshields.module;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.basicshields.util.ContentModule;
import com.github.crimsondawn45.basicshields.util.ModItem;
import com.github.crimsondawn45.basicshields.util.RecipeHelper;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import com.google.gson.JsonObject;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.item.Item;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.Tag.Identified;
import net.minecraft.util.Identifier;

public class PeridotModule extends ContentModule {

    //Peridot Stuff
    public ModItem peridot_shield;
    public JsonObject peridot_shield_recipe;

    //Peridot tag
    public Identified<Item> peridot_tag;

    public PeridotModule(String...requiredIds) {
        super(requiredIds);
    }

    @Override
    public void registerContent() {

        //Tag
        peridot_tag = TagFactory.ITEM.create(new Identifier("c", "peridot_gems"));

        //Item
        peridot_shield = new ModItem("peridot_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(1008).group(BasicShields.SHIELDS), 90, 12, peridot_tag));

        //Recipe
        peridot_shield_recipe = RecipeHelper.createShieldRecipe(peridot_tag.getId(), true, ItemTags.PLANKS.getId(), true, peridot_shield.getIdentifier());
    }
}
