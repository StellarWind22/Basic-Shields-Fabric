package com.github.crimsondawn45.basicshields.registry;

import com.github.crimsondawn45.basicshields.BasicShields;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import com.github.crimsondawn45.util.ModItem;
import com.github.crimsondawn45.util.RecipeHelper;
import com.google.gson.JsonObject;
import com.kwpugh.gobber2.init.ItemInit;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Items;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Identifier;
import techreborn.init.TRContent;

public class ModItems {

	//Regular Items
    public static ModItem wooden_shield;
	public static ModItem golden_shield;
	public static ModItem diamond_shield;
	public static ModItem netherite_shield;
        //Regular recipes
    public static JsonObject wooden_shield_recipe;
    public static JsonObject golden_shield_recipe;
    public static JsonObject diamond_shield_recipe;
    //public static JsonObject netherite_shield_recipe;

	//Tech Reborn Items
	public static ModItem bronze_shield;
	public static ModItem ruby_shield;
	public static ModItem peridot_shield;
	public static ModItem sapphire_shield;
	    //Tech reborn recipes
	public static JsonObject bronze_shield_recipe;
	public static JsonObject ruby_shield_recipe;
	public static JsonObject peridot_shield_recipe;
	public static JsonObject sapphire_shield_recipe;

    //Gobber Items
    public static ModItem gobber_shield;
    public static ModItem gobber_nether_shield;
    public static ModItem gobber_end_shield;
        //Gobber recipes
    public static JsonObject gobber_shield_recipe;
    public static JsonObject gobber_nether_shield_recipe;
    public static JsonObject gobber_end_shield_recipe;

    public static void Init() {

		/**
         * Vanilla
         */
        wooden_shield = new ModItem("wooden_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(80).group(BasicShields.SHIELDS), 110, 15, ItemTags.PLANKS));
        wooden_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("c", "wood_sticks"), true, wooden_shield.getIdentifier());

		golden_shield = new ModItem("golden_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(43).group(BasicShields.SHIELDS), 80, 22, Items.GOLD_INGOT));
        golden_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("c", "gold_ingots"), true, golden_shield.getIdentifier());


		diamond_shield = new ModItem("diamond_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(2097).group(BasicShields.SHIELDS), 90, 10, Items.DIAMOND));
        diamond_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("minecraft", "diamond"), false, diamond_shield.getIdentifier());


		netherite_shield = new ModItem("netherite_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(2709).group(BasicShields.SHIELDS).fireproof(), 80, 15, Items.NETHERITE_INGOT));

		/**
         * Tech Reborn
         */
		if(BasicShields.isLoaded("techreborn")) {

			//Bronze
			bronze_shield = new ModItem("bronze_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(504).group(BasicShields.SHIELDS), 100, 6, TRContent.Ingots.BRONZE.asItem()));
			bronze_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("c", "bronze_ingots"), true, bronze_shield.getIdentifier());

			//Ruby
			ruby_shield = new ModItem("ruby_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(1008).group(BasicShields.SHIELDS), 90, 10, TRContent.Gems.RUBY.asItem()));
			ruby_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("c", "rubies"), true, ruby_shield.getIdentifier());

			//Peridot
			peridot_shield = new ModItem("peridot_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(1008).group(BasicShields.SHIELDS), 90, 12, TRContent.Gems.PERIDOT.asItem()));
			peridot_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("c", "peridot_gems"), true, peridot_shield.getIdentifier());

			//Saphire
			sapphire_shield = new ModItem("sapphire_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(1344).group(BasicShields.SHIELDS), 90, 12, TRContent.Gems.SAPPHIRE.asItem()));
			sapphire_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("c", "sapphires"), true, sapphire_shield.getIdentifier());
		}

        /**
         * Gobber
         */
        if(BasicShields.isLoaded("gobber2")) {

            //Gobber
            gobber_shield = new ModItem("gobber_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(1111), 100, 111, ItemInit.GOBBER2_INGOT));
            gobber_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("gobber2", "gobber2_ingot"), true, gobber_shield.getIdentifier());

            //Nether Gobber
            gobber_nether_shield = new ModItem("gobber_nether_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(1111), 100, 111, ItemInit.GOBBER2_INGOT_NETHER));
            gobber_nether_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("gobber2", "gobber2_ingot_nether"), true, gobber_shield.getIdentifier());

            //End Gobber
            gobber_end_shield = new ModItem("gobber_end_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(1111), 100, 111, ItemInit.GOBBER2_INGOT_END));
            gobber_end_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("gobber2", "gobber2_ingot_end"), true, gobber_shield.getIdentifier());
        }
    }
}