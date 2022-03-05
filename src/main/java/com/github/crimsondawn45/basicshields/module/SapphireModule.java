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

public class SapphireModule extends ContentModule {

    //Sapphire Stuff
    public ModItem sapphire_shield;

    //Tag
    public TagKey<Item> sapphire_tag;

    public SapphireModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        sapphire_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "sapphires"));

        //Item
        sapphire_shield = new ModShieldItem(this,"sapphire_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.sapphire_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.sapphire_shield_cooldown,
        BasicShields.CONFIG.sapphire_shield_enchantability,
        sapphire_tag),
        "entity/sapphire_shield_base");

        //Recipe
        this.addRecipe(sapphire_shield, ModRecipe.createShieldRecipe(sapphire_tag.id(), true, sapphire_shield.getIdentifier()));
    }
}
