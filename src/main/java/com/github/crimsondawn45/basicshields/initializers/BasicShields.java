package com.github.crimsondawn45.basicshields.initializers;

import com.github.crimsondawn45.basicshields.config.BasicShieldsConfig;
import com.github.crimsondawn45.basicshields.module.AdabraniumModule;
import com.github.crimsondawn45.basicshields.module.AlexandriteModule;
import com.github.crimsondawn45.basicshields.module.BronzeModule;
import com.github.crimsondawn45.basicshields.module.CarbonadoModule;
import com.github.crimsondawn45.basicshields.module.CitrineModule;
import com.github.crimsondawn45.basicshields.module.CorundumModule;
import com.github.crimsondawn45.basicshields.module.GobberModule;
import com.github.crimsondawn45.basicshields.module.KunziteModule;
import com.github.crimsondawn45.basicshields.module.MoissaniteModule;
import com.github.crimsondawn45.basicshields.module.PeridotModule;
import com.github.crimsondawn45.basicshields.module.RubyModule;
import com.github.crimsondawn45.basicshields.module.SapphireModule;
import com.github.crimsondawn45.basicshields.module.SpinelModule;
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
	public static VanillaModule vanilla;
	public static AlexandriteModule alexandrite;
	public static BronzeModule bronze;
	public static CarbonadoModule carbonado;
	public static CitrineModule citrine;
	public static CorundumModule corundumModule;
	public static KunziteModule kunzite;
	public static MoissaniteModule moissanite;
	public static RubyModule ruby;
	public static PeridotModule peridot;
	public static SapphireModule sapphire;
	public static SpinelModule spinel;
	public static TopazModule topaz;
	public static TourmalineModule tourmaline;
	public static AdabraniumModule adabranium;
	public static GobberModule gobber;

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
		vanilla = 		new VanillaModule();
		bronze = 		new BronzeModule(		CONFIG.always_load_bronze, 		"techreborn", "astromine", "mythicmetals", "texp", "mw", "modern_industrialization", "indrev");
		citrine = 		new CitrineModule(		CONFIG.always_load_citrine, 	"more_gems");
		ruby =			new RubyModule(			CONFIG.always_load_ruby, 		"techreborn");
		peridot = 		new PeridotModule(		CONFIG.always_load_peridot,		"techreborn");
		sapphire = 		new SapphireModule(		CONFIG.always_load_sapphire,	"techreborn", "more_gems");
		adabranium = 	new AdabraniumModule(	CONFIG.always_load_adabranium, 	"adabraniummod");
		gobber =		new GobberModule(		CONFIG.always_load_gobber, 		"gobber2");

		LOGGER.info("Basic Shields initialized!");
	}
}
