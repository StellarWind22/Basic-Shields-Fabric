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

public class KunziteModule extends ContentModule {

    //Kunzite Stuff
    public ModItem kunzite_shield;

    //Tag
    public TagKey<Item> kunzite_tag;

    public KunziteModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        kunzite_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "kunzite"));

        //Item
        kunzite_shield = new ModShieldItem(this,"kunzite_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.kunzite_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.kunzite_shield_cooldown,
        BasicShields.CONFIG.kunzite_shield_enchantability,
        kunzite_tag),
        "entity/kunzite_shield_base");

        //Recipe
        this.addRecipe(kunzite_shield, ModRecipe.createShieldRecipe(kunzite_tag.id(), true, kunzite_shield.getIdentifier()));
    }
}
