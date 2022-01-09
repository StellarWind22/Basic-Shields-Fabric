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

public class VanillaModule extends ContentModule {

    //Regular Items
    public ModItem wooden_shield;
	public ModItem golden_shield;
	public ModItem diamond_shield;
	public ModItem netherite_shield;

    //Regular recipes
    public JsonObject wooden_shield_recipe;
    public JsonObject golden_shield_recipe;
    public JsonObject diamond_shield_recipe;
    public JsonObject netherite_shield_recipe;

    //Tags
    public Identified<Item> gold_tag;
    public Identified<Item> diamond_tag;
    public Identified<Item> netherite_tag;

    @Override
    public void registerContent() {

        //Wood
        wooden_shield = new ModItem("wooden_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(104).group(BasicShields.SHIELDS), 110, 15, ItemTags.LOGS));
        wooden_shield_recipe = RecipeHelper.createShieldRecipe(ItemTags.LOGS.getId(), true, wooden_shield.getIdentifier());

        //Gold
            //Tag
        gold_tag = TagFactory.ITEM.create(new Identifier("c", "gold_ingots"));
            //Item
		golden_shield = new ModItem("golden_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(44).group(BasicShields.SHIELDS), 100, 22, gold_tag));
            //Recipe
        golden_shield_recipe = RecipeHelper.createShieldRecipe(gold_tag.getId(), true, golden_shield.getIdentifier());

        //Diamond
            //Tag
        diamond_tag = TagFactory.ITEM.create(new Identifier("c","diamonds"));
            //Item
		diamond_shield = new ModItem("diamond_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(2098).group(BasicShields.SHIELDS), 90, 10, diamond_tag));
            //Recipe
        diamond_shield_recipe = RecipeHelper.createShieldRecipe(diamond_tag.getId(), true, diamond_shield.getIdentifier());

        //Netherite
            //Tag
        netherite_tag = TagFactory.ITEM.create(new Identifier("c", "netherite_ingots"));
            //Item
		netherite_shield = new ModItem("netherite_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(2730).group(BasicShields.SHIELDS).fireproof(), 80, 15, netherite_tag));
            //Recipe
        netherite_shield_recipe = RecipeHelper.createSmithingRecipe(diamond_shield.getIdentifier(), false, netherite_tag.getId(), true, netherite_shield.getIdentifier());
    }
}