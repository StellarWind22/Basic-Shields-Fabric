package com.github.crimsondawn45.basicshields.module;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import com.github.crimsondawn45.util.ContentModule;
import com.github.crimsondawn45.util.ModItem;
import com.github.crimsondawn45.util.RecipeHelper;
import com.google.gson.JsonObject;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Identifier;
import techreborn.init.TRContent;

public class TechRebornModule extends ContentModule {

    //Tech Reborn Items
	public ModItem bronze_shield;
	public ModItem ruby_shield;
	public ModItem peridot_shield;
	public ModItem sapphire_shield;
	    //Tech reborn recipes
	public JsonObject bronze_shield_recipe;
	public JsonObject ruby_shield_recipe;
	public JsonObject peridot_shield_recipe;
	public JsonObject sapphire_shield_recipe;

    public TechRebornModule(String...requiredIds) {
        super(requiredIds);
    }

    @Override
    public void registerContent() {

        //Bronze
        bronze_shield = new ModItem("bronze_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(504).group(BasicShields.SHIELDS), 100, 6, TRContent.Ingots.BRONZE.asItem()));
        bronze_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("c", "bronze_ingots"), true, ItemTags.PLANKS.getId(), true, bronze_shield.getIdentifier());

        //Ruby
        ruby_shield = new ModItem("ruby_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(1008).group(BasicShields.SHIELDS), 90, 10, TRContent.Gems.RUBY.asItem()));
        ruby_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("c", "rubies"), true, ItemTags.PLANKS.getId(), true, ruby_shield.getIdentifier());

        //Peridot
        peridot_shield = new ModItem("peridot_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(1008).group(BasicShields.SHIELDS), 90, 12, TRContent.Gems.PERIDOT.asItem()));
        peridot_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("c", "peridot_gems"), true, ItemTags.PLANKS.getId(), true, peridot_shield.getIdentifier());

        //Saphire
        sapphire_shield = new ModItem("sapphire_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(1344).group(BasicShields.SHIELDS), 90, 12, TRContent.Gems.SAPPHIRE.asItem()));
        sapphire_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("c", "sapphires"), true, ItemTags.PLANKS.getId(), true, sapphire_shield.getIdentifier());
    }
}