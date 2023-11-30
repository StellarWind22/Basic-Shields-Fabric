package com.github.crimsondawn45.basicshields.module;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.basicshields.util.ContentModule;
import com.github.crimsondawn45.basicshields.util.ModItem;
import com.github.crimsondawn45.basicshields.util.ModRecipe;
import com.github.crimsondawn45.basicshields.util.ModShieldItem;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class VanillaModule extends ContentModule {

    //Regular Items
    public ModItem wooden_shield;
	public ModItem golden_shield;
	public ModItem diamond_shield;
	public ModItem netherite_shield;

    //Tags
    public TagKey<Item> gold_tag;
    public TagKey<Item> diamond_tag;
    public TagKey<Item> netherite_tag;

    @Override
    public void registerContent() {

        //Tags
        gold_tag = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "gold_ingots"));
        diamond_tag = TagKey.of(RegistryKeys.ITEM, new Identifier("c","diamonds"));
        netherite_tag = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "netherite_ingots"));

        //Wood
        wooden_shield = new ModShieldItem(this, "wooden_shield",
            new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.vanilla_wooden_shield_durability),
            BasicShields.CONFIG.vanilla_wooden_shield_cooldown,
            BasicShields.CONFIG.vanilla_wooden_shield_enchantability,
            ItemTags.LOGS),
            "entity/wooden_shield_base");

        //Recipe
        this.addRecipe(wooden_shield, ModRecipe.createShieldRecipe(ItemTags.LOGS.id(), true, wooden_shield.getIdentifier()));

        //Gold
		golden_shield = new ModShieldItem(this, "golden_shield",
            new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.vanilla_golden_shield_durability),
            BasicShields.CONFIG.vanilla_golden_shield_cooldown,
            BasicShields.CONFIG.vanilla_golden_shield_enchantability,
            gold_tag),
            "entity/golden_shield_base");

        //Recipe
        this.addRecipe(golden_shield, ModRecipe.createShieldRecipe(gold_tag.id(), true, golden_shield.getIdentifier()));

        //Diamond
		diamond_shield = new ModShieldItem(this, "diamond_shield",
            new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.vanilla_diamond_shield_durability),
            BasicShields.CONFIG.vanilla_diamond_shield_cooldown,
            BasicShields.CONFIG.vanilla_diamond_shield_enchantability,
            diamond_tag),
            "entity/diamond_shield_base");

        //Recipe
        this.addRecipe(diamond_shield, ModRecipe.createShieldRecipe(diamond_tag.id(), true, diamond_shield.getIdentifier()));

        //Netherite
		netherite_shield = new ModShieldItem(this, "netherite_shield",
            new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.vanilla_netherite_shield_durability).fireproof(),
            BasicShields.CONFIG.vanilla_netherite_shield_cooldown,
            BasicShields.CONFIG.vanilla_netherite_shield_enchantability,
            netherite_tag),
            "entity/netherite_shield_base");

        //Recipe
        this.addRecipe(netherite_shield, ModRecipe.createSmithingRecipe(diamond_shield.getIdentifier(), false, netherite_tag.id(), true, netherite_shield.getIdentifier()));

        //Item Group
        BasicShields.SHIELDS.entries((context, entries) -> {
            entries.add(wooden_shield.getItem());
            entries.add(golden_shield.getItem());
            entries.add(diamond_shield.getItem());
            entries.add(netherite_shield.getItem());
        });
    }
}