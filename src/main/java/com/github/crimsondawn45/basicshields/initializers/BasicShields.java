package com.github.crimsondawn45.basicshields.initializers;

import com.github.crimsondawn45.basicshields.module.AdabraniumModule;
import com.github.crimsondawn45.basicshields.module.BronzeModule;
import com.github.crimsondawn45.basicshields.module.GobberModule;
import com.github.crimsondawn45.basicshields.module.PeridotModule;
import com.github.crimsondawn45.basicshields.module.RubyModule;
import com.github.crimsondawn45.basicshields.module.SapphireModule;
import com.github.crimsondawn45.basicshields.module.VanillaModule;
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

	//Modules
	public static VanillaModule vanilla;
	public static BronzeModule bronze;
	public static RubyModule ruby;
	public static PeridotModule peridot;
	public static SapphireModule sapphire;
	public static AdabraniumModule adabranium;
	public static GobberModule gobber;

	//Item Group
	public static ItemGroup SHIELDS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "shields"), () -> new ItemStack(vanilla.diamond_shield.getItem()));

	@Override
	public void onInitialize() {
		
		//Initialize Modules
		vanilla = 		new VanillaModule();
		bronze = 		new BronzeModule("techreborn", "astromine", "mythicmetals", "texp", "mw", "modern_industrialization", "indrev");
		ruby =			new RubyModule("techreborn");
		peridot = 		new PeridotModule("techreborn");
		sapphire = 		new SapphireModule("techreborn", "more_gems");
		adabranium = 	new AdabraniumModule("adabraniummod");
		gobber =		new GobberModule("gobber2");

		LOGGER.info("Basic Shields initialized!");
	}
}
