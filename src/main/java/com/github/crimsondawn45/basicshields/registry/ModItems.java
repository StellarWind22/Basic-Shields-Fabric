package com.github.crimsondawn45.basicshields.registry;

import java.util.ArrayList;

import com.github.crimsondawn45.basicshields.BasicShields;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import com.github.crimsondawn45.util.ModItem;
import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;
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

    public static void Init() {

		FabricLoader loader = FabricLoader.getInstance();

		//Vanilla
        wooden_shield = new ModItem("wooden_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(80).group(BasicShields.SHIELDS), 110, 15, ItemTags.PLANKS));
		golden_shield = new ModItem("golden_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(43).group(BasicShields.SHIELDS), 80, 22, Items.GOLD_INGOT));
		diamond_shield = new ModItem("diamond_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(2097).group(BasicShields.SHIELDS), 90, 10, Items.DIAMOND));
		netherite_shield = new ModItem("netherite_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(2709).group(BasicShields.SHIELDS).fireproof(), 80, 15, Items.NETHERITE_INGOT));

		//Tech Reborn
		if(loader.isModLoaded("techreborn")) {

			//Bronze
			bronze_shield = new ModItem("bronze_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(504).group(BasicShields.SHIELDS), 100, 6, TRContent.Ingots.BRONZE.asItem()));
			bronze_shield_recipe = createShieldRecipe(new Identifier("techreborn", "bronze_ingot"), false, bronze_shield.getIdentifier());

			//Ruby
			ruby_shield = new ModItem("ruby_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(1008).group(BasicShields.SHIELDS), 90, 10, TRContent.Gems.RUBY.asItem()));
			ruby_shield_recipe = createShieldRecipe(new Identifier("techreborn", "ruby_gem"), false, ruby_shield.getIdentifier());

			//Peridot
			peridot_shield = new ModItem("peridot_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(1008).group(BasicShields.SHIELDS), 90, 12, TRContent.Gems.PERIDOT.asItem()));
			peridot_shield_recipe = createShieldRecipe(new Identifier("techreborn", "peridot_gem"), false, peridot_shield.getIdentifier());

			//Saphire
			sapphire_shield = new ModItem("sapphire_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(1344).group(BasicShields.SHIELDS), 90, 12, TRContent.Gems.SAPPHIRE.asItem()));
			sapphire_shield_recipe = createShieldRecipe(new Identifier("techreborn", "sapphire_gem"), false, sapphire_shield.getIdentifier());
		}
    }

	public static JsonObject createShieldRecipe(Identifier CraftingItemIdentifier, boolean isTag, Identifier output) {
		String itemType;

		if(isTag) {
			itemType = "tag";
		} else {
			itemType = "item";
		}

		return createShapedRecipeJson(
			//Keys
			Lists.newArrayList('#','i'),
			//Items
			Lists.newArrayList(ItemTags.PLANKS.getId(), CraftingItemIdentifier), 
			//Types
			Lists.newArrayList("tag", itemType),
			//Pattern
			Lists.newArrayList(
				"#i#",
				"###",
				" # "
			),
			//Output
			output);
	}

	public static JsonObject createShapedRecipeJson(ArrayList<Character> keys, ArrayList<Identifier> items, ArrayList<String> type, ArrayList<String> pattern, Identifier output) {
        //Creating a new json object, where we will store our recipe.
        JsonObject json = new JsonObject();
        //The "type" of the recipe we are creating. In this case, a shaped recipe.
        json.addProperty("type", "minecraft:crafting_shaped");
        //This creates:
        //"type": "minecraft:crafting_shaped"
 
        //We create a new Json Element, and add our crafting pattern to it.
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(pattern.get(0));
        jsonArray.add(pattern.get(1));
        jsonArray.add(pattern.get(2));
        //Then we add the pattern to our json object.
        json.add("pattern", jsonArray);
        //This creates:
        //"pattern": [
        //  "###",
        //  " | ",
        //  " | "
        //]
 
        //Next we need to define what the keys in the pattern are. For this we need different JsonObjects per key definition, and one main JsonObject that will contain all of the defined keys.
        JsonObject individualKey; //Individual key
        JsonObject keyList = new JsonObject(); //The main key object, containing all the keys
 
        for (int i = 0; i < keys.size(); ++i) {
            individualKey = new JsonObject();
            individualKey.addProperty(type.get(i), items.get(i).toString()); //This will create a key in the form "type": "input", where type is either "item" or "tag", and input is our input item.
            keyList.add(keys.get(i) + "", individualKey); //Then we add this key to the main key object.
            //This will add:
            //"#": { "tag": "c:copper_ingots" }
            //and after that
            //"|": { "item": "minecraft:sticks" }
            //and so on.
        }
 
        json.add("key", keyList);
        //And so we get:
        //"key": {
        //  "#": {
        //    "tag": "c:copper_ingots"
        //  },
        //  "|": {
        //    "item": "minecraft:stick"
        //  }
        //},
 
        //Finally, we define our result object
        JsonObject result = new JsonObject();
        result.addProperty("item", output.toString());
        result.addProperty("count", 1);
        json.add("result", result);
        //This creates:
        //"result": {
        //  "item": "modid:copper_pickaxe",
        //  "count": 1
        //}
 
        return json;
    }
}