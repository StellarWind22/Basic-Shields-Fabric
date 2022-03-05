package com.github.crimsondawn45.basicshields.module;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.basicshields.util.ContentModule;
import com.github.crimsondawn45.basicshields.util.ModItem;
import com.github.crimsondawn45.basicshields.util.ModRecipe;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

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
        vibranium_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c","vibranium_ingots"));
        adamantium_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c","adamantium_ingots"));
        
        //Nether
        nether_shield = new ModItem("nether_shield",
            new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.adabranium_nether_shield_durability).group(BasicShields.SHIELDS).fireproof(),
            BasicShields.CONFIG.adabranium_nether_shield_cooldown,
            BasicShields.CONFIG.adabranium_nether_shield_enchantability,
            Items.NETHER_BRICK));
        this.addRecipe(nether_shield, ModRecipe.createSmithingRecipe(new Identifier("minecraft", "shield"), false, new Identifier("minecraft", "nether_brick"), false, nether_shield.getIdentifier()));
       
        //Vibranium
        vibranium_shield = new ModItem("vibranium_shield",
            new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.adabranium_vibranium_shield_durability).group(BasicShields.SHIELDS),
            BasicShields.CONFIG.adabranium_vibranium_shield_cooldown,
            BasicShields.CONFIG.adabranium_vibranium_shield_enchantability,
            vibranium_tag));
        this.addRecipe(vibranium_shield, ModRecipe.createShieldRecipe(vibranium_tag.id(), true, vibranium_shield.getIdentifier()));

        //Adamantium
        adamantium_shield = new ModItem("adamantium_shield",
            new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.adabranium_adamantium_shield_durability).group(BasicShields.SHIELDS),
            BasicShields.CONFIG.adabranium_adamantium_shield_cooldown,
            BasicShields.CONFIG.adabranium_adamantium_shield_enchantability,
            adamantium_tag));
        this.addRecipe(adamantium_shield, ModRecipe.createShieldRecipe(adamantium_tag.id(), true, adamantium_shield.getIdentifier()));
    }
}