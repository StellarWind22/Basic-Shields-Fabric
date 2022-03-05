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

public class CorundumModule extends ContentModule {

    //Corundum Stuff
    public ModItem corundum_shield;

    //Tag
    public TagKey<Item> corundum_tag;

    public CorundumModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        corundum_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "corundum"));

        //Item
        corundum_shield = new ModItem("corundum_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.corundum_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.corundum_shield_cooldown,
        BasicShields.CONFIG.corundum_shield_enchantability,
        corundum_tag));

        //Recipe
        this.addRecipe(corundum_shield, ModRecipe.createShieldRecipe(corundum_tag.id(), true, corundum_shield.getIdentifier()));
    }
}
