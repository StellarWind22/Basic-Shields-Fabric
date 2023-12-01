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

public class BronzeModule extends ContentModule {

    //Bronze Stuff
    public ModItem bronze_shield;

    //Tag
    public TagKey<Item> bronze_tag;

    public BronzeModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        bronze_tag = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "bronze_ingots"));

        //Item
        bronze_shield = new ModShieldItem(this,"bronze_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.bronze_shield_durability),
        BasicShields.CONFIG.bronze_shield_cooldown,
        BasicShields.CONFIG.bronze_shield_enchantability,
        bronze_tag),
        "entity/bronze_shield_base");

        //Recipe
        this.addRecipe(bronze_shield, ModRecipe.createShieldRecipe(bronze_tag.id(), true, bronze_shield.getIdentifier()));
    }
}
