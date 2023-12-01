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

public class RubyModule extends ContentModule {

    //Ruby Stuff
    public ModItem ruby_shield;

    //Tag
    public TagKey<Item> ruby_tag;

    public RubyModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        ruby_tag = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "rubies"));

        //Item
        ruby_shield = new ModShieldItem(this,"ruby_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.ruby_shield_durability),
        BasicShields.CONFIG.ruby_shield_cooldown,
        BasicShields.CONFIG.ruby_shield_enchantability,
        ruby_tag),
        "entity/ruby_shield_base");

        //Recipe
        this.addRecipe(ruby_shield, ModRecipe.createShieldRecipe(ruby_tag.id(), true, ruby_shield.getIdentifier()));
    }
}
