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

public class SapphireModule extends ContentModule {

    //Peridot Stuff
    public ModItem sapphire_shield;
    public JsonObject sapphire_shield_recipe;

    //Peridot tag
    public Identified<Item> sapphire_tag;

    public SapphireModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }
 
    @Override
    public void registerContent() {
 
        //Tag
        sapphire_tag = TagFactory.ITEM.create(new Identifier("c","sapphires"));

        //Item
        sapphire_shield = new ModItem("sapphire_shield",
        new BasicShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.sapphire_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.sapphire_shield_cooldown,
        BasicShields.CONFIG.sapphire_shield_enchantability,
        sapphire_tag));

        //Recipe
        sapphire_shield_recipe = RecipeHelper.createShieldRecipe(sapphire_tag.getId(), true, sapphire_shield.getIdentifier());
    }
}