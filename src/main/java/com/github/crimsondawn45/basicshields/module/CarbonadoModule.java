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

public class CarbonadoModule extends ContentModule {

    //Carbonado Stuff
    public ModItem carbonado_shield;

    //Tag
    public TagKey<Item> carbonado_tag;

    public CarbonadoModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        carbonado_tag = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "carbonado"));

        //Item
        carbonado_shield = new ModShieldItem(this,"carbonado_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.carbonado_shield_durability),
        BasicShields.CONFIG.carbonado_shield_cooldown,
        BasicShields.CONFIG.carbonado_shield_enchantability,
        carbonado_tag),
        "entity/carbonado_shield_base");

        //Recipe
        this.addRecipe(carbonado_shield, ModRecipe.createShieldRecipe(carbonado_tag.id(), true, carbonado_shield.getIdentifier()));

        //Group
        BasicShields.SHIELDS.entries((context, entries) -> {
            entries.add(carbonado_shield.getItem());
        });
    }
}
