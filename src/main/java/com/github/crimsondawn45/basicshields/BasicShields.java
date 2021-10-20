package com.github.crimsondawn45.basicshields;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BasicShields implements ModInitializer {

	public static final String MOD_ID = "basicshields";

	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	public static ItemGroup MOD_GROUP;

	//Wooden
	public static final Item wooden_shield = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(80).group(MOD_GROUP), 110, 15, Items.OAK_PLANKS);

	//Golden
	public static final Item golden_shield = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(43).group(MOD_GROUP), 90, 22, Items.GOLD_INGOT);

	//Diamond
	public static final Item diamond_shield = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(2097).group(MOD_GROUP), 90, 10, Items.DIAMOND);

	//Netherite
	public static final Item netherite_shield = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(2709).group(MOD_GROUP).fireproof(), 80, 15, Items.NETHERITE_INGOT);
	

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

		//Item Group
		MOD_GROUP = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "shields")).icon(() -> new ItemStack(diamond_shield)).build();

		LOGGER.info("Basic Shields initialized!");
	}
}
