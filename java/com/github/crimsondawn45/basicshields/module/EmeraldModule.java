package com.github.crimsondawn45.basicshields.module;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.basicshields.util.ContentModule;
import com.github.crimsondawn45.basicshields.util.ModItem;
import com.github.crimsondawn45.basicshields.util.ModRecipe;
import com.github.crimsondawn45.basicshields.util.ModShieldItem;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EmeraldModule extends ContentModule {

    //Emerald Stuff
    public ModItem emerald_shield;

    //Tag
    public TagKey<Item> emerald_tag;

    public EmeraldModule(boolean alwaysLoad, boolean isVanillaMaterial, String...ids) {
        super(alwaysLoad, isVanillaMaterial, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        emerald_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "emeralds"));

        //Item
        emerald_shield = new ModShieldItem(this,"emerald_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.emerald_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.emerald_shield_cooldown,
        BasicShields.CONFIG.emerald_shield_enchantability,
        emerald_tag),
        "entity/emerald_shield_base");

        //Recipe
        this.addRecipe(emerald_shield, ModRecipe.createShieldRecipe(emerald_tag.id(), true, emerald_shield.getIdentifier()));
    }
}
