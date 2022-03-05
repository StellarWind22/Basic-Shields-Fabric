package com.github.crimsondawn45.basicshields.module;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.basicshields.util.ContentModule;
import com.github.crimsondawn45.basicshields.util.ModItem;
import com.github.crimsondawn45.basicshields.util.ModRecipe;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

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
        tourmaline_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "tourmaline"));

        //Item
        tourmaline_shield = new ModItem("tourmaline_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.tourmaline_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.tourmaline_shield_cooldown,
        BasicShields.CONFIG.tourmaline_shield_enchantability,
        tourmaline_tag));

        //Recipe
        this.addRecipe(tourmaline_shield, ModRecipe.createShieldRecipe(tourmaline_tag.id(), true, tourmaline_shield.getIdentifier()));
    }
}
