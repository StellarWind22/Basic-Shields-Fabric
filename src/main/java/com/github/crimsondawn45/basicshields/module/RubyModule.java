package com.github.crimsondawn45.basicshields.module;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.basicshields.util.ContentModule;
import com.github.crimsondawn45.basicshields.util.ModItem;
import com.github.crimsondawn45.basicshields.util.RecipeHelper;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import com.google.gson.JsonObject;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RubyModule extends ContentModule {

    //Ruby Stuff
    public ModItem ruby_shield;
    public JsonObject ruby_shield_recipe;

    //Ruby tag
    public TagKey<Item> ruby_tag;

    public RubyModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        ruby_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c","rubies"));
        
        //Item
        ruby_shield = new ModItem("ruby_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.ruby_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.ruby_shield_cooldown,
        BasicShields.CONFIG.ruby_shield_enchantability,
        ruby_tag));

        //Recipe
        ruby_shield_recipe = RecipeHelper.createShieldRecipe(ruby_tag.id(), true, ruby_shield.getIdentifier());
    }
}