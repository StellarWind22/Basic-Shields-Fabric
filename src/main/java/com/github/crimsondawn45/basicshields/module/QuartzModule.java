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

public class QuartzModule extends ContentModule {

    //Quartz Stuff
    public ModItem quartz_shield;

    //Tag
    public net.minecraft.registry.tag.TagKey<Item> quartz_tag;

    public QuartzModule(boolean alwaysLoad, boolean isVanillaMaterial, String...ids) {
        super(alwaysLoad, isVanillaMaterial, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        quartz_tag = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "quartz"));

        //Item
        quartz_shield = new ModShieldItem(this,"quartz_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.quartz_shield_durability),
        BasicShields.CONFIG.quartz_shield_cooldown,
        BasicShields.CONFIG.quartz_shield_enchantability,
        quartz_tag),
        "entity/quartz_shield_base");

        //Recipe
        this.addRecipe(quartz_shield, ModRecipe.createShieldRecipe(quartz_tag.id(), true, quartz_shield.getIdentifier()));
    }
}
