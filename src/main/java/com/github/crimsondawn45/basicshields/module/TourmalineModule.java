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
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class TourmalineModule extends ContentModule {

    //Tourmaline Stuff
    public ModItem tourmaline_shield;

    //Tag
    public TagKey<Item> tourmaline_tag;

    public TourmalineModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        tourmaline_tag = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "tourmaline"));

        //Item
        tourmaline_shield = new ModShieldItem(this,"tourmaline_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.tourmaline_shield_durability),
        BasicShields.CONFIG.tourmaline_shield_cooldown,
        BasicShields.CONFIG.tourmaline_shield_enchantability,
        tourmaline_tag),
        "entity/tourmaline_shield_base");

        //Recipe
        this.addRecipe(tourmaline_shield, ModRecipe.createShieldRecipe(tourmaline_tag.id(), true, tourmaline_shield.getIdentifier()));

        //Group
        BasicShields.SHIELDS.entries((context, entries) -> {
            entries.add(tourmaline_shield.getItem());
        });
    }
}
