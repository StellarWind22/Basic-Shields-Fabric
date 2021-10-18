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

	//Wood
	public static final Item wood_shield = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(2500).group(ItemGroup.COMBAT), 80, 15, Items.OAK_PLANKS);
	public static final EntityModelLayer wood_shield_model_layer = new EntityModelLayer(new Identifier(MOD_ID, "wood_shield"),"main");

	//Gold
	public static final Item gold_shield = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(2500).group(ItemGroup.COMBAT), 43, 22, Items.GOLD_INGOT);
	public static final EntityModelLayer gold_shield_model_layer = new EntityModelLayer(new Identifier(MOD_ID, "gold_shield"),"main");


	//Diamond
	public static final Item diamond_shield = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(2500).group(ItemGroup.COMBAT), 2097, 10, Items.DIAMOND);
	public static final EntityModelLayer diamond_shield_model_layer = new EntityModelLayer(new Identifier(MOD_ID, "diamond_shield"),"main");


	//Netherite
	public static final Item netherite_shield = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(2500).group(ItemGroup.COMBAT).fireproof(), 2709, 15, Items.NETHERITE_INGOT);
	public static final EntityModelLayer netherite_shield_model_layer = new EntityModelLayer(new Identifier(MOD_ID, "netherite_shield"),"main");

	

	@Override
	public void onInitialize() {

		//Wood
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "wood_shield"), wood_shield);

		//Gold
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "gold_shield"), gold_shield);

		//Diamond
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "diamond_shield"), diamond_shield);

		//Netherite
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "netherite_shield"), netherite_shield);

		LOGGER.info("VanillaPlus shields initialized!");
	}
}
