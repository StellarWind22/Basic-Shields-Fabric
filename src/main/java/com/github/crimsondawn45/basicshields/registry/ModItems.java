package com.github.crimsondawn45.basicshields.registry;

import com.github.crimsondawn45.basicshields.BasicShields;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import com.github.crimsondawn45.util.ModItem;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Items;

public class ModItems {

	//Regular Items
    public static ModItem wooden_shield;
	public static ModItem golden_shield;
	public static ModItem diamond_shield;
	public static ModItem netherite_shield;

	//Tech Reborn Items
	//public static ModItem bronze_shield;
	//public static ModItem ruby_shield;
	//public static ModItem saphire_shield;
	//public static ModItem peridot_shield;

    public static void Init() {
        wooden_shield = new ModItem("wooden_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(80).group(BasicShields.SHIELDS), 110, 15, Items.OAK_PLANKS));
		golden_shield = new ModItem("golden_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(43).group(BasicShields.SHIELDS), 90, 22, Items.GOLD_INGOT));
		diamond_shield = new ModItem("diamond_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(2097).group(BasicShields.SHIELDS), 90, 10, Items.DIAMOND));
		netherite_shield = new ModItem("netherite_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(2709).group(BasicShields.SHIELDS).fireproof(), 80, 15, Items.NETHERITE_INGOT));
    }

	/*
	public static void TechRebornInit() {
		
	}
	*/
}
