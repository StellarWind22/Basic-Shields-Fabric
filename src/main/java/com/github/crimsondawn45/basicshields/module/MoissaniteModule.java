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

public class MoissaniteModule extends ContentModule {

    //Bronze Stuff
    public ModItem moissanite_shield;
    public JsonObject moissanite_shield_recipe;

    //Tag
    public Identified<Item> moissanite_tag;

    public MoissaniteModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        moissanite_tag = TagFactory.ITEM.create(new Identifier("c","moissanites"));

        //Item
        moissanite_shield = new ModItem("moissanite_shield",
        new BasicShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.moissanite_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.moissanite_shield_cooldown,
        BasicShields.CONFIG.moissanite_shield_enchantability,
        moissanite_tag));

        //Recipe
        moissanite_shield_recipe = RecipeHelper.createShieldRecipe(moissanite_tag.getId(), true, moissanite_shield.getIdentifier());
    }
    
}
