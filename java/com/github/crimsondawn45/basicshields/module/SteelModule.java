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

public class SteelModule extends ContentModule {

    //Steel Stuff
    public ModItem steel_shield;

    //Tag
    public TagKey<Item> steel_tag;

    public SteelModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        steel_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "steel_ingots"));

        //Item
        steel_shield = new ModShieldItem(this,"steel_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.steel_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.steel_shield_cooldown,
        BasicShields.CONFIG.steel_shield_enchantability,
        steel_tag),
        "entity/steel_shield_base");

        //Recipe
        this.addRecipe(steel_shield, ModRecipe.createShieldRecipe(steel_tag.id(), true, steel_shield.getIdentifier()));
    }
}
