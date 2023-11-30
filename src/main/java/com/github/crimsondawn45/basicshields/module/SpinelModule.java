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

public class SpinelModule extends ContentModule {

    //Spinel Stuff
    public ModItem spinel_shield;

    //Tag
    public TagKey<Item> spinel_tag;

    public SpinelModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        spinel_tag = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "spinel"));

        //Item
        spinel_shield = new ModShieldItem(this,"spinel_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.spinel_shield_durability),
        BasicShields.CONFIG.spinel_shield_cooldown,
        BasicShields.CONFIG.spinel_shield_enchantability,
        spinel_tag),
        "entity/spinel_shield_base");

        //Recipe
        this.addRecipe(spinel_shield, ModRecipe.createShieldRecipe(spinel_tag.id(), true, spinel_shield.getIdentifier()));

        //Group
        BasicShields.SHIELDS.entries((context, entries) -> {
            entries.add(spinel_shield.getItem());
        });
    }
}
