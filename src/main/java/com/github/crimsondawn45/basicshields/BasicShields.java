package com.github.crimsondawn45.basicshields;

import com.github.crimsondawn45.basicshields.objects.ModItems;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class BasicShields implements ModInitializer {

	public static final String MOD_ID = "basicshields";

	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	//Item Group
	public static ItemGroup SHIELDS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "shields"), () -> new ItemStack(ModItems.diamond_shield.getItem()));

	@Override
	public void onInitialize() {

		//Initialize Items
		ModItems.Init();

		LOGGER.info("Basic Shields initialized!");
	}
}
