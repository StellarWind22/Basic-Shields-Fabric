package com.github.crimsondawn45.basicshields.initializers;

import com.github.crimsondawn45.basicshields.config.BasicShieldsConfig;
import com.github.crimsondawn45.basicshields.module.AdabraniumModule;
import com.github.crimsondawn45.basicshields.module.AlexandriteModule;
import com.github.crimsondawn45.basicshields.module.AmethystModule;
import com.github.crimsondawn45.basicshields.module.BronzeModule;
import com.github.crimsondawn45.basicshields.module.CarbonadoModule;
import com.github.crimsondawn45.basicshields.module.CitrineModule;
import com.github.crimsondawn45.basicshields.module.CopperModule;
import com.github.crimsondawn45.basicshields.module.CorundumModule;
import com.github.crimsondawn45.basicshields.module.EmeraldModule;
import com.github.crimsondawn45.basicshields.module.GobberModule;
import com.github.crimsondawn45.basicshields.module.KunziteModule;
import com.github.crimsondawn45.basicshields.module.MoissaniteModule;
import com.github.crimsondawn45.basicshields.module.ObsidianModule;
import com.github.crimsondawn45.basicshields.module.PeridotModule;
import com.github.crimsondawn45.basicshields.module.QuartzModule;
import com.github.crimsondawn45.basicshields.module.RubyModule;
import com.github.crimsondawn45.basicshields.module.SapphireModule;
import com.github.crimsondawn45.basicshields.module.SpinelModule;
import com.github.crimsondawn45.basicshields.module.SteelModule;
import com.github.crimsondawn45.basicshields.module.TopazModule;
import com.github.crimsondawn45.basicshields.module.TourmalineModule;
import com.github.crimsondawn45.basicshields.module.VanillaModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class BasicShields implements ModInitializer {

	public static final String MOD_ID = "basicshields";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	//Modules
	public static VanillaModule 		vanilla;
	public static AdabraniumModule 		adabranium;
	public static AlexandriteModule 	alexandrite;
	public static AmethystModule 		amethyst;
	public static BronzeModule 			bronze;
	public static CarbonadoModule 		carbonado;
	public static CitrineModule 		citrine;
	public static CopperModule 			copper;
	public static CorundumModule 		corundum;
	public static EmeraldModule 		emerald;
	public static GobberModule 			gobber;
	public static KunziteModule 		kunzite;
	public static MoissaniteModule 		moissanite;
	public static ObsidianModule 		obsidian;
	public static PeridotModule 		peridot;
	public static QuartzModule 			quartz;
	public static RubyModule 			ruby;
	public static SapphireModule 		sapphire;
	public static SpinelModule 			spinel;
	public static SteelModule 			steel;
	public static TopazModule 			topaz;
	public static TourmalineModule 		tourmaline;

	//Item Group
	public static ItemGroup SHIELDS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "shields"), () -> new ItemStack(vanilla.diamond_shield.getItem()));

	//Config
	public static BasicShieldsConfig CONFIG = new BasicShieldsConfig();

	@Override
	public void onInitialize() {

		/**
		 * Register Config
		 */
        AutoConfig.register(BasicShieldsConfig.class, GsonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(BasicShieldsConfig.class).getConfig();   //Read config data
		
		//Initialize Modules
		/**
		 * Information on what mods use what materials mostly comes from here https://www.fabricmc.net/wiki/tutorial:tags
		 */
		vanilla = 		new VanillaModule();
		adabranium = 	new AdabraniumModule(	CONFIG.always_load_adabranium, 	"adabraniummod");
		gobber =		new GobberModule(		CONFIG.always_load_gobber, 		"gobber2");
		alexandrite =	new AlexandriteModule(	CONFIG.always_load_alexandrite, "more_gems");
		amethyst =		new AmethystModule(     CONFIG.always_load_amethyst, 	"emerald_tools", "gemsandcrystals", "amethystequipment");
		bronze = 		new BronzeModule(		CONFIG.always_load_bronze, 		"techreborn", "astromine", "mythicmetals", "texp", "mw", "modern_industrialization", "indrev");
		carbonado =		new CarbonadoModule(	CONFIG.always_load_carbonado, 	"more_gems");
		citrine = 		new CitrineModule(		CONFIG.always_load_citrine, 	"more_gems");
		copper = 		new CopperModule(		CONFIG.always_load_copper, 		"emerald_tools", "copperarmorandtools", "copperequipment");
		corundum = 		new CorundumModule(     CONFIG.always_load_corundum, 	"more_gems");
		emerald =		new EmeraldModule(		CONFIG.always_load_emerald, 	"emerald_tools", "gemsandcrystals", "enriched", "emeraldequipment");
		kunzite =		new KunziteModule(      CONFIG.always_load_kunzite, 	"more_gems");
		moissanite = 	new MoissaniteModule(   CONFIG.always_load_moissanite, 	"more_gems");
		obsidian =		new ObsidianModule(		CONFIG.always_load_obsidian, 	"emerald_tools");
		peridot = 		new PeridotModule(		CONFIG.always_load_peridot,		"techreborn");
		quartz =		new QuartzModule( 		CONFIG.always_load_quartz, 		"gemsandcrystals");
		ruby =			new RubyModule(			CONFIG.always_load_ruby, 		"techreborn", "emerald_tools", "gemsandcrystals", "enriched");
		sapphire = 		new SapphireModule(		CONFIG.always_load_sapphire,	"techreborn", "more_gems", "gemsandcrystals", "enriched");
		spinel = 		new SpinelModule(       CONFIG.always_load_spinel, 		"more_gems");
		steel =			new SteelModule(		CONFIG.always_load_steel, 		"astromine", "emerald_tools", "indrev", "modern_industrialization", "mw", "mythicmetals", "techreborn", "enriched");
		topaz =			new TopazModule(        CONFIG.always_load_topaz, 		"more_gems", "gemsandcrystals");
		tourmaline =	new TourmalineModule(   CONFIG.always_load_tourmaline, 	"more_gems");

		LOGGER.info("Basic Shields initialized!");
	}
}
