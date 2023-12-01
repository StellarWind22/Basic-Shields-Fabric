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
        citrine_tag = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "citrine"));

        //Item
        citrine_shield = new ModShieldItem(this,"citrine_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.citrine_shield_durability),
        BasicShields.CONFIG.citrine_shield_cooldown,
        BasicShields.CONFIG.citrine_shield_enchantability,
        citrine_tag),
        "entity/citrine_shield_base");

        //Recipe
        this.addRecipe(citrine_shield, ModRecipe.createShieldRecipe(citrine_tag.id(), true, citrine_shield.getIdentifier()));
    }
}
