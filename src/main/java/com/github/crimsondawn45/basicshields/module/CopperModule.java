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

public class CopperModule extends ContentModule {

    //Copper Stuff
    public ModItem copper_shield;

    //Tag
    public net.minecraft.registry.tag.TagKey<Item> copper_tag;

    public CopperModule(boolean alwaysLoad, boolean isVanillaMaterial, String...ids) {
        super(alwaysLoad, isVanillaMaterial, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        copper_tag = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "copper_ingots"));

        //Item
        copper_shield = new ModShieldItem(this,"copper_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.copper_shield_durability),
        BasicShields.CONFIG.copper_shield_cooldown,
        BasicShields.CONFIG.copper_shield_enchantability,
        copper_tag),
        "entity/copper_shield_base");

        //Recipe
        this.addRecipe(copper_shield, ModRecipe.createShieldRecipe(copper_tag.id(), true, copper_shield.getIdentifier()));
    }
}
