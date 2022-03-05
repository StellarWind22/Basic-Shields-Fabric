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

public class TopazModule extends ContentModule {

    //Topaz Stuff
    public ModItem topaz_shield;

    //Tag
    public TagKey<Item> topaz_tag;

    public TopazModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        topaz_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "topaz"));

        //Item
        topaz_shield = new ModItem("topaz_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.topaz_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.topaz_shield_cooldown,
        BasicShields.CONFIG.topaz_shield_enchantability,
        topaz_tag));

        //Recipe
        this.addRecipe(topaz_shield, ModRecipe.createShieldRecipe(topaz_tag.id(), true, topaz_shield.getIdentifier()));
    }
}
