package com.github.crimsondawn45.basicshields.module;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.basicshields.util.ContentModule;
import com.github.crimsondawn45.basicshields.util.ModItem;
import com.github.crimsondawn45.basicshields.util.ModRecipe;
import com.github.crimsondawn45.basicshields.util.ModShieldItem;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class AdabraniumModule extends ContentModule {

    //Adabranium Items
    public ModItem adamantium_shield;
    public ModItem vibranium_shield;
    public ModItem nether_shield;

    //Tags
    public TagKey<Item> vibranium_tag;
    public TagKey<Item> adamantium_tag;

    public AdabraniumModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tags
        vibranium_tag = TagKey.of(RegistryKeys.ITEM, new Identifier("c","vibranium_ingots"));
        adamantium_tag = TagKey.of(RegistryKeys.ITEM, new Identifier("c","adamantium_ingots"));
        
        //Nether
        nether_shield = new ModShieldItem(this, "nether_shield",
            new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.adabranium_nether_shield_durability).fireproof(),
            BasicShields.CONFIG.adabranium_nether_shield_cooldown,
            BasicShields.CONFIG.adabranium_nether_shield_enchantability,
            Items.NETHER_BRICK),
            "entity/nether_shield_base");

        //Recipe
        this.addRecipe(nether_shield, ModRecipe.createSmithingRecipe(new Identifier("minecraft","nether_brick"), false, new Identifier("minecraft", "shield"), false, new Identifier("minecraft", "nether_brick"), false, nether_shield.getIdentifier()));
       
        //Vibranium
        vibranium_shield = new ModShieldItem(this, "vibranium_shield",
            new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.adabranium_vibranium_shield_durability),
            BasicShields.CONFIG.adabranium_vibranium_shield_cooldown,
            BasicShields.CONFIG.adabranium_vibranium_shield_enchantability,
            vibranium_tag),
            "entity/vibranium_shield_base");

        //Recipe
        this.addRecipe(vibranium_shield, ModRecipe.createShieldRecipe(vibranium_tag.id(), true, vibranium_shield.getIdentifier()));

        //Adamantium
        adamantium_shield = new ModShieldItem(this, "adamantium_shield",
            new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.adabranium_adamantium_shield_durability),
            BasicShields.CONFIG.adabranium_adamantium_shield_cooldown,
            BasicShields.CONFIG.adabranium_adamantium_shield_enchantability,
            adamantium_tag),
            "entity/adamantium_shield_base");

        //Recipe
        this.addRecipe(adamantium_shield, ModRecipe.createShieldRecipe(adamantium_tag.id(), true, adamantium_shield.getIdentifier()));
    }
}