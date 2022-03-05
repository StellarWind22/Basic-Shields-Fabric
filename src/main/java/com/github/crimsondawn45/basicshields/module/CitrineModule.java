package com.github.crimsondawn45.basicshields.module;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.basicshields.util.ContentModule;
import com.github.crimsondawn45.basicshields.util.ModItem;
import com.github.crimsondawn45.basicshields.util.ModRecipe;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CitrineModule extends ContentModule {

    //Citrine Stuff
    public ModItem citrine_shield;

    //Tag
    public TagKey<Item> citrine_tag;

    public CitrineModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        citrine_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "citrine"));

        //Item
        citrine_shield = new ModItem("citrine_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.citrine_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.citrine_shield_cooldown,
        BasicShields.CONFIG.citrine_shield_enchantability,
        citrine_tag));

        //Recipe
        this.addRecipe(citrine_shield, ModRecipe.createShieldRecipe(citrine_tag.id(), true, citrine_shield.getIdentifier()));
    }
}
