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

        //Tags
        gold_tag = TagFactory.ITEM.create(new Identifier("c", "gold_ingots"));
        diamond_tag = TagFactory.ITEM.create(new Identifier("c","diamonds"));
        netherite_tag = TagFactory.ITEM.create(new Identifier("c", "netherite_ingots"));

        //Wood
        wooden_shield = new ModItem("wooden_shield",
            new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.vanilla_wooden_shield_durability).group(BasicShields.SHIELDS),
            BasicShields.CONFIG.vanilla_wooden_shield_cooldown,
            BasicShields.CONFIG.vanilla_wooden_shield_enchantability,
            ItemTags.LOGS));
        wooden_shield_recipe = RecipeHelper.createShieldRecipe(ItemTags.LOGS.getId(), true, wooden_shield.getIdentifier());

        //Gold
		golden_shield = new ModItem("golden_shield",
            new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.vanilla_golden_shield_durability).group(BasicShields.SHIELDS),
            BasicShields.CONFIG.vanilla_golden_shield_cooldown,
            BasicShields.CONFIG.vanilla_golden_shield_enchantability,
            gold_tag));
        golden_shield_recipe = RecipeHelper.createShieldRecipe(gold_tag.getId(), true, golden_shield.getIdentifier());

        //Diamond
		diamond_shield = new ModItem("diamond_shield",
            new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.vanilla_diamond_shield_durability).group(BasicShields.SHIELDS),
            BasicShields.CONFIG.vanilla_diamond_shield_cooldown,
            BasicShields.CONFIG.vanilla_diamond_shield_enchantability,
            diamond_tag));
        diamond_shield_recipe = RecipeHelper.createShieldRecipe(diamond_tag.getId(), true, diamond_shield.getIdentifier());

        //Netherite
		netherite_shield = new ModItem("netherite_shield",
            new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.vanilla_netherite_shield_durability).group(BasicShields.SHIELDS).fireproof(),
            BasicShields.CONFIG.vanilla_netherite_shield_cooldown,
            BasicShields.CONFIG.vanilla_netherite_shield_enchantability,
            netherite_tag));
        netherite_shield_recipe = RecipeHelper.createSmithingRecipe(diamond_shield.getIdentifier(), false, netherite_tag.getId(), true, netherite_shield.getIdentifier());
    }
}