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

public class PeridotModule extends ContentModule {

    //Peridot Stuff
    public ModItem peridot_shield;

    //Tag
    public TagKey<Item> peridot_tag;

    public PeridotModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        peridot_tag = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "peridot"));

        //Item
        peridot_shield = new ModShieldItem(this,"peridot_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.peridot_shield_durability),
        BasicShields.CONFIG.peridot_shield_cooldown,
        BasicShields.CONFIG.peridot_shield_enchantability,
        peridot_tag),
        "entity/peridot_shield_base");

        //Recipe
        this.addRecipe(peridot_shield, ModRecipe.createShieldRecipe(peridot_tag.id(), true, peridot_shield.getIdentifier()));

        //Group
        BasicShields.SHIELDS.entries((context, entries) -> {
            entries.add(peridot_shield.getItem());
        });
    }
}
