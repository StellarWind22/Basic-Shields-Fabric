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

public class AmethystModule extends ContentModule {

    //Amethyst Stuff
    public ModItem amethyst_shield;

    //Tag
    public net.minecraft.registry.tag.TagKey<Item> amethyst_tag;

    public AmethystModule(boolean alwaysLoad, boolean isVanillaMaterial, String...ids) {
        super(alwaysLoad, isVanillaMaterial, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        amethyst_tag = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "amethyst"));

        //Item
        amethyst_shield = new ModShieldItem(this,"amethyst_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.amethyst_shield_durability),
        BasicShields.CONFIG.amethyst_shield_cooldown,
        BasicShields.CONFIG.amethyst_shield_enchantability,
        amethyst_tag),
        "entity/amethyst_shield_base");

        //Recipe
        this.addRecipe(amethyst_shield, ModRecipe.createShieldRecipe(amethyst_tag.id(), true, amethyst_shield.getIdentifier()));
    }
}
