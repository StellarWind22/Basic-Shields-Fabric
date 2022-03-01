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

public class AlexandriteModule extends ContentModule {

    //Bronze Stuff
    public ModItem alexandrite_shield;
    public JsonObject alexandrite_shield_recipe;

    //Tag
    public Identified<Item> alexandrite_tag;

    public AlexandriteModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        alexandrite_tag = TagFactory.ITEM.create(new Identifier("c","alexandrites"));

        //Item
        alexandrite_shield = new ModItem("alexandrite_shield",
        new BasicShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.alexandrite_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.alexandrite_shield_cooldown,
        BasicShields.CONFIG.alexandrite_shield_enchantability,
        alexandrite_tag));

        //Recipe
        alexandrite_shield_recipe = RecipeHelper.createShieldRecipe(alexandrite_tag.getId(), true, alexandrite_shield.getIdentifier());
    }
    
}
