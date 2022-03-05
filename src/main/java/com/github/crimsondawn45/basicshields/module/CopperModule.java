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

public class CopperModule extends ContentModule {

    //Copper Stuff
    public ModItem copper_shield;

    //Tag
    public TagKey<Item> copper_tag;

    public CopperModule(boolean forceLoad, boolean isVanillaMaterial, String...ids) {
        super(forceLoad, isVanillaMaterial, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        copper_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "copper_ingots"));

        //TODO: make shield oxidize
        //TODO: make a way to wax the shield

        //Item
        copper_shield = new ModShieldItem(
            this,
            "copper_shield",
            new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.copper_shield_durability).group(BasicShields.SHIELDS),
            BasicShields.CONFIG.copper_shield_cooldown,
            BasicShields.CONFIG.copper_shield_enchantability,
            copper_tag),
            "entity/copper_shield_base");

        //Recipe
        this.addRecipe(copper_shield, ModRecipe.createShieldRecipe(copper_tag.id(), true, copper_shield.getIdentifier()));
    }
}
