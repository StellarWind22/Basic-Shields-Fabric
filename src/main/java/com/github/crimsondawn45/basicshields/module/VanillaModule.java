package com.github.crimsondawn45.basicshields.module;

import com.github.crimsondawn45.basicshields.initializer.BasicShields;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import com.github.crimsondawn45.util.ContentModule;
import com.github.crimsondawn45.util.ModItem;
import com.github.crimsondawn45.util.RecipeHelper;
import com.google.gson.JsonObject;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Items;
import net.minecraft.tag.ItemTags;
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
    //public JsonObject netherite_shield_recipe;

    @Override
    public void registerContent() {
        //Wood
        wooden_shield = new ModItem("wooden_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(80).group(BasicShields.SHIELDS), 110, 15, ItemTags.PLANKS));
        wooden_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("c", "wood_sticks"), true, wooden_shield.getIdentifier());

        //Gold
		golden_shield = new ModItem("golden_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(43).group(BasicShields.SHIELDS), 80, 22, Items.GOLD_INGOT));
        golden_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("c", "gold_ingots"), true, golden_shield.getIdentifier());

        //Diamond
		diamond_shield = new ModItem("diamond_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(2097).group(BasicShields.SHIELDS), 90, 10, Items.DIAMOND));
        diamond_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("minecraft", "diamond"), false, diamond_shield.getIdentifier());

        //Netherite
		netherite_shield = new ModItem("netherite_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(2709).group(BasicShields.SHIELDS).fireproof(), 80, 15, Items.NETHERITE_INGOT));
    }
}
