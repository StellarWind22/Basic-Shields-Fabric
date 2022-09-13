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

public class AlexandriteModule extends ContentModule {

    //Alexandrite Stuff
    public ModItem alexandrite_shield;

    //Tag
    public TagKey<Item> alexandrite_tag;

    public AlexandriteModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        alexandrite_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "alexandrite"));

        //Item
        alexandrite_shield = new ModShieldItem(this,"alexandrite_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.alexandrite_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.alexandrite_shield_cooldown,
        BasicShields.CONFIG.alexandrite_shield_enchantability,
        alexandrite_tag),
        "entity/alexandrite_shield_base");

        //Recipe
        this.addRecipe(alexandrite_shield, ModRecipe.createShieldRecipe(alexandrite_tag.id(), true, alexandrite_shield.getIdentifier()));
    }
}
