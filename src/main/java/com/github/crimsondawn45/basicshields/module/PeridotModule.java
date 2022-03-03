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

public class PeridotModule extends ContentModule {

    //Peridot Stuff
    public ModItem peridot_shield;
    public JsonObject peridot_shield_recipe;

    //Peridot tag
    public TagKey<Item> peridot_tag;

    public PeridotModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        peridot_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c","peridots"));

        //Item
        peridot_shield = new ModItem("peridot_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.peridot_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.peridot_shield_cooldown,
        BasicShields.CONFIG.peridot_shield_enchantability,
        peridot_tag));

        //Recipe
        peridot_shield_recipe = RecipeHelper.createShieldRecipe(peridot_tag.id(), true, peridot_shield.getIdentifier());
    }
}
