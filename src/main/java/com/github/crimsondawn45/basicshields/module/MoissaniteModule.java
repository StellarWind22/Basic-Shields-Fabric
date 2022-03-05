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

public class MoissaniteModule extends ContentModule {

    //Moissanite Stuff
    public ModItem moissanite_shield;

    //Tag
    public TagKey<Item> moissanite_tag;

    public MoissaniteModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        moissanite_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "moissanite"));

        //Item
        moissanite_shield = new ModItem("moissanite_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.moissanite_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.moissanite_shield_cooldown,
        BasicShields.CONFIG.moissanite_shield_enchantability,
        moissanite_tag));

        //Recipe
        this.addRecipe(moissanite_shield, ModRecipe.createShieldRecipe(moissanite_tag.id(), true, moissanite_shield.getIdentifier()));
    }
}
