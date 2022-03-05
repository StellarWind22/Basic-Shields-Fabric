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

public class TanzaniteModule extends ContentModule {

    //Tanzanite Stuff
    public ModItem tanzanite_shield;

    //Tag
    public TagKey<Item> tanzanite_tag;

    public TanzaniteModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        tanzanite_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "tanzanite"));

        //Item
        tanzanite_shield = new ModShieldItem(this,"tanzanite_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.tanzanite_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.tanzanite_shield_cooldown,
        BasicShields.CONFIG.tanzanite_shield_enchantability,
        tanzanite_tag),
        "entity/tanzanite_shield_base");

        //Recipe
        this.addRecipe(tanzanite_shield, ModRecipe.createShieldRecipe(tanzanite_tag.id(), true, tanzanite_shield.getIdentifier()));
    }
}
