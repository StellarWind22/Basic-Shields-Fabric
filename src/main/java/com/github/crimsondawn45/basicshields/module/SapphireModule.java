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

public class SapphireModule extends ContentModule {

     //Peridot Stuff
     public ModItem sapphire_shield;
     public JsonObject sapphire_shield_recipe;
 
     //Peridot tag
     public Identified<Item> sapphire_tag;
 
     public SapphireModule(String...requiredIds) {
         super(requiredIds);
     }
 
     @Override
     public void registerContent() {
 
        //Tag
        sapphire_tag = TagFactory.ITEM.create(new Identifier("c", "sapphires"));

        //Item
        sapphire_shield = new ModItem("sapphire_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(1344).group(BasicShields.SHIELDS), 90, 12, sapphire_tag));

        //Recipe
        sapphire_shield_recipe = RecipeHelper.createShieldRecipe(sapphire_tag.getId(), true, ItemTags.PLANKS.getId(), true, sapphire_shield.getIdentifier());
     }
}
