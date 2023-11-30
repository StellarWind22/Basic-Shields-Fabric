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

public class TopazModule extends ContentModule {

    //Topaz Stuff
    public ModItem topaz_shield;

    //Tag
    public TagKey<Item> topaz_tag;

    public TopazModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        topaz_tag = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "topaz"));

        //Item
        topaz_shield = new ModShieldItem(this,"topaz_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.topaz_shield_durability),
        BasicShields.CONFIG.topaz_shield_cooldown,
        BasicShields.CONFIG.topaz_shield_enchantability,
        topaz_tag),
        "entity/topaz_shield_base");

        //Recipe
        this.addRecipe(topaz_shield, ModRecipe.createShieldRecipe(topaz_tag.id(), true, topaz_shield.getIdentifier()));

        //Group
        BasicShields.SHIELDS.entries((context, entries) -> {
            entries.add(topaz_shield.getItem());
        });
    }
}
