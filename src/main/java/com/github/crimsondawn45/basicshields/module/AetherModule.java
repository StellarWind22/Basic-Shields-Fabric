package com.github.crimsondawn45.basicshields.module;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.basicshields.util.ContentModule;
import com.github.crimsondawn45.basicshields.util.ModItem;
import com.github.crimsondawn45.basicshields.util.ModRecipe;
import com.github.crimsondawn45.fabricshieldlib.lib.event.ShieldBlockCallback;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import com.google.gson.JsonObject;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AetherModule extends ContentModule {

    //Aether Stuff
    public ModItem zanite_shield;
    public ModItem candy_shield;
    public ModItem gravitite_shield;
    public ModItem valkyrie_shield;
    public ModItem legendary_shield;

    //Recipes
    public JsonObject zanite_shield_recipe;
    public JsonObject candy_shield_recipe;
    public JsonObject gravitite_shield_recipe;
    public JsonObject valkyrie_shield_recipe;
    public JsonObject legendary_shield_recipe;

    //Tag
    public TagKey<Item> zanite_tag;
    public TagKey<Item> candy_tag;
    public TagKey<Item> gravitite_tag;
    public TagKey<Item> valkyrie_tag;
    public TagKey<Item> legendary_tag;

    public AetherModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Aether Shield Event
        ShieldBlockCallback.EVENT.register((defender, source, amount, hand, shield) -> {

            if(shield.getItem().equals(zanite_shield.getItem())) {

            }

            if(shield.getItem().equals(candy_shield.getItem())) {
                
            }

            if(shield.getItem().equals(gravitite_shield.getItem())) {
                
            }

            if(shield.getItem().equals(valkyrie_shield.getItem())) {
                
            }

            if(shield.getItem().equals(legendary_shield.getItem())) {
                
            }
            return ActionResult.PASS;
        });

        //Tag
        zanite_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c","zanite_ingots"));
        candy_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c","candy_ingots"));
        gravitite_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c","gravitite"));
        valkyrie_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c","valkyrie_ingots"));
        legendary_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c","legendary_ingots"));

        //Item
        zanite_shield = new ModItem("zanite_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.zanite_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.zanite_shield_cooldown,
        BasicShields.CONFIG.zanite_shield_enchantability,
        zanite_tag));

        //Recipe
        this.addRecipe(zanite_shield, ModRecipe.createShieldRecipe(zanite_tag.id(), true, zanite_shield.getIdentifier()));

        //Item
        candy_shield = new ModItem("candy_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.candy_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.candy_shield_cooldown,
        BasicShields.CONFIG.candy_shield_enchantability,
        candy_tag));

        //Recipe
        this.addRecipe(candy_shield, ModRecipe.createShieldRecipe(candy_tag.id(), true, candy_shield.getIdentifier()));

        //Item
        gravitite_shield = new ModItem("gravitite_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.gravitite_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.gravitite_shield_cooldown,
        BasicShields.CONFIG.gravitite_shield_enchantability,
        gravitite_tag));

        //Recipe
        this.addRecipe(gravitite_shield, ModRecipe.createShieldRecipe(gravitite_tag.id(), true, gravitite_shield.getIdentifier()));

        //Item
        valkyrie_shield = new ModItem("valkyrie_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.valkyrie_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.valkyrie_shield_cooldown,
        BasicShields.CONFIG.valkyrie_shield_enchantability,
        valkyrie_tag));

        //Recipe
        this.addRecipe(valkyrie_shield, ModRecipe.createShieldRecipe(valkyrie_tag.id(), true, valkyrie_shield.getIdentifier()));

        //Item
        legendary_shield = new ModItem("legendary_shield",
        new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.legendary_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.legendary_shield_cooldown,
        BasicShields.CONFIG.legendary_shield_enchantability,
        legendary_tag));

        //Recipe
        this.addRecipe(legendary_shield, ModRecipe.createShieldRecipe(legendary_tag.id(), true, legendary_shield.getIdentifier()));
    }
}
