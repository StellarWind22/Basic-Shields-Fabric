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

public class ObsidianModule extends ContentModule {

    //Obsidian Stuff
    public ModItem obsidian_shield;

    //Tag
    public TagKey<Item> obsidian_tag;

    public ObsidianModule(boolean alwaysLoad, boolean isVanillaMaterial, String...ids) {
        super(alwaysLoad, isVanillaMaterial, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        obsidian_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "obsidian"));

        //Item
        obsidian_shield = new ModShieldItem(this,"obsidian_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.obsidian_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.obsidian_shield_cooldown,
        BasicShields.CONFIG.obsidian_shield_enchantability,
        obsidian_tag),
        "entity/obsidian_shield_base");

        //Recipe
        this.addRecipe(obsidian_shield, ModRecipe.createShieldRecipe(obsidian_tag.id(), true, obsidian_shield.getIdentifier()));
    }
}
