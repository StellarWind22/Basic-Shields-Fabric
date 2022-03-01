package com.github.crimsondawn45.basicshields.module;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.basicshields.object.GobberShieldItem;
import com.github.crimsondawn45.basicshields.util.ContentModule;
import com.github.crimsondawn45.basicshields.util.ModItem;
import com.github.crimsondawn45.basicshields.util.RecipeHelper;
import com.github.crimsondawn45.fabricshieldlib.lib.event.ShieldBlockCallback;
import com.google.gson.JsonObject;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag.Identified;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;

public class GobberModule extends ContentModule {
    //Gobber Items
    public ModItem gobber_shield;
    public ModItem gobber_nether_shield;
    public ModItem gobber_end_shield;
    public ModItem gobber_dragon_shield;
    //Gobber recipes
    public JsonObject gobber_shield_recipe;
    public JsonObject gobber_nether_shield_recipe;
    public JsonObject gobber_end_shield_recipe;
    public JsonObject gobber_dragon_shield_recipe;

    //Tags
    public Identified<Item> gobber_tag;
    public Identified<Item> gobber_nether_tag;
    public Identified<Item> gobber_end_tag;
    public Identified<Item> gobber_dragon_tag;

    public GobberModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Generic Gobber Event
        ShieldBlockCallback.EVENT.register((defender, source, amount, hand, shield) -> {

            //All gobber shields reflect damage
            if(shield.getItem().equals(gobber_nether_shield.getItem()) || shield.getItem().equals(gobber_shield.getItem()) || shield.getItem().equals(gobber_end_shield.getItem()) || shield.getItem().equals(gobber_dragon_shield.getItem())) {
                
                Entity attacker = source.getAttacker();
                assert attacker != null;

                //Reflect damage because thats a more generic effect all gobber shields will have.
                if(defender instanceof PlayerEntity) {
                    PlayerEntity player = (PlayerEntity) defender;
                    attacker.damage(DamageSource.player(player), Math.round(amount * BasicShields.CONFIG.gobber_reflect_percentage));
                } else {
                    attacker.damage(DamageSource.mob(defender), Math.round(amount * BasicShields.CONFIG.gobber_reflect_percentage));
                }
            }
            return ActionResult.PASS;
        });

        //Tags
        gobber_tag = TagFactory.ITEM.create(new Identifier("c","gobber2_ingots"));
        gobber_nether_tag = TagFactory.ITEM.create(new Identifier("c","gobber2_ingots_nether"));
        gobber_end_tag = TagFactory.ITEM.create(new Identifier("c","gobber2_ingots_end"));
        gobber_dragon_tag = TagFactory.ITEM.create(new Identifier("c","gobber2_dragon_stars"));

        //Gobber
        gobber_shield = new ModItem("gobber_shield",
            new GobberShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.gobber_dragon_shield_durability).group(BasicShields.SHIELDS),
            BasicShields.CONFIG.gobber_shield_cooldown,
            BasicShields.CONFIG.gobber_shield_enchantability,
            BasicShields.CONFIG.unbreakable_gobber_shield,
            gobber_tag));
        gobber_shield_recipe = RecipeHelper.createShieldRecipe(gobber_tag.getId(), true, gobber_shield.getIdentifier());

        //Nether Gobber
        gobber_nether_shield = new ModItem("gobber_nether_shield",
            new GobberShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.gobber_nether_shield_durability).group(BasicShields.SHIELDS),
            BasicShields.CONFIG.gobber_nether_shield_cooldown,
            BasicShields.CONFIG.gobber_nether_shield_enchantability,
            BasicShields.CONFIG.unbreakable_gobber_nether_shield,
            gobber_nether_tag));
        gobber_nether_shield_recipe = RecipeHelper.createShieldRecipe(gobber_nether_tag.getId(), true, gobber_nether_shield.getIdentifier());

        //End Gobber
        gobber_end_shield = new ModItem("gobber_end_shield",
            new GobberShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.gobber_end_shield_durability).group(BasicShields.SHIELDS),
            BasicShields.CONFIG.gobber_end_shield_cooldown,
            BasicShields.CONFIG.gobber_end_shield_enchantability,
            BasicShields.CONFIG.unbreakable_gobber_end_shield,
            gobber_end_tag));
        gobber_end_shield_recipe = RecipeHelper.createShieldRecipe(gobber_end_tag.getId(), false, gobber_end_shield.getIdentifier());

        //Dragon Gobber
        gobber_dragon_shield = new ModItem("gobber_dragon_shield",
        new GobberShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.gobber_dragon_shield_durability).group(BasicShields.SHIELDS),
            BasicShields.CONFIG.gobber_dragon_shield_cooldown,
            BasicShields.CONFIG.gobber_dragon_shield_enchantability,
            BasicShields.CONFIG.unbreakable_gobber_dragon_shield,
            gobber_dragon_tag));
        gobber_dragon_shield_recipe = RecipeHelper.createSmithingRecipe(gobber_end_shield.getIdentifier(), false, gobber_dragon_tag.getId(), true, gobber_dragon_shield.getIdentifier());
    }
}