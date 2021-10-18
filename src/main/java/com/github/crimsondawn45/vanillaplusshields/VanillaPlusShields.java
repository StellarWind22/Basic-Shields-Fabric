package com.github.crimsondawn45.vanillaplusshields;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class VanillaPlusShields implements ModInitializer {

	public static final String MOD_ID = "vanillaplusshields";

	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	//Wooden
	public static final Item wooden_shield = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(80).group(ItemGroup.COMBAT), 110, 15, Items.OAK_PLANKS);
	public static final EntityModelLayer wooden_shield_model_layer = new EntityModelLayer(new Identifier(MOD_ID, "wooden_shield"),"main");

	//Golden
	public static final Item golden_shield = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(43).group(ItemGroup.COMBAT), 90, 22, Items.GOLD_INGOT);
	public static final EntityModelLayer golden_shield_model_layer = new EntityModelLayer(new Identifier(MOD_ID, "golden_shield"),"main");


	//Diamond
	public static final Item diamond_shield = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(2097).group(ItemGroup.COMBAT), 90, 10, Items.DIAMOND);
	public static final EntityModelLayer diamond_shield_model_layer = new EntityModelLayer(new Identifier(MOD_ID, "diamond_shield"),"main");


	//Netherite
	public static final Item netherite_shield = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(2709).group(ItemGroup.COMBAT).fireproof(), 80, 15, Items.NETHERITE_INGOT);
	public static final EntityModelLayer netherite_shield_model_layer = new EntityModelLayer(new Identifier(MOD_ID, "netherite_shield"),"main");

	

	@Override
	public void onInitialize() {

		//Wooden
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "wooden_shield"), wooden_shield);

		//Golden
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "golden_shield"), golden_shield);

		//Diamond
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "diamond_shield"), diamond_shield);

		//Netherite
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "netherite_shield"), netherite_shield);

		LOGGER.info("VanillaPlus shields initialized!");
	}
}
