package com.github.crimsondawn45.basicshields.module;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.fabricshieldlib.lib.event.ShieldBlockCallback;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import com.github.crimsondawn45.util.ContentModule;
import com.github.crimsondawn45.util.ModItem;
import com.github.crimsondawn45.util.RecipeHelper;
import com.google.gson.JsonObject;
import com.kwpugh.gobber2.init.ItemInit;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;

public class GobberModule extends ContentModule {

    //Gobber Items
    public ModItem gobber_shield;
    public ModItem gobber_nether_shield;
    public ModItem gobber_end_shield;
         //Gobber recipes
    public JsonObject gobber_shield_recipe;
    public JsonObject gobber_nether_shield_recipe;
    public JsonObject gobber_end_shield_recipe;

    public GobberModule(String...requiredIds) {
        super(requiredIds);
    }

    //TODO: make overworld gobber INSERT COOL THING HERE
    //TODO: make end gobber give attacking enemies levitation

    @Override
    public void registerContent() {
        //Gobber
        gobber_shield = new ModItem("gobber_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(3800).group(BasicShields.SHIELDS), 100, 20, ItemInit.GOBBER2_INGOT));
        gobber_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("c","emeralds"), true, new Identifier("gobber2", "gobber2_ingot"), false, gobber_shield.getIdentifier());

        //Nether Gobber
        gobber_nether_shield = new ModItem("gobber_nether_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(5200).group(BasicShields.SHIELDS), 100, 25, ItemInit.GOBBER2_INGOT_NETHER));
        gobber_nether_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("minecraft","nether_star"), false, new Identifier("gobber2", "gobber2_ingot_nether"), false, gobber_nether_shield.getIdentifier());

        //TODO: add check for wearing all nether armor while using
        //Nether Gobber Special Effect
        ShieldBlockCallback.EVENT.register((defender, source, amount, hand, shield) -> {

            if(shield.getItem().equals(gobber_nether_shield.getItem())) {   //Check for nether shield
                
                Entity attacker = source.getAttacker();
                assert attacker != null;

                //Burn because that's related to fire protection.
                attacker.setOnFireFor(12);   //Equivalent to if Fire Aspect could go to level 3

                //Reflect 10% damage because thats a more generic effect all gobber shields will have.
                if(defender instanceof PlayerEntity) {
                    PlayerEntity player = (PlayerEntity) defender;
                    attacker.damage(DamageSource.player(player), Math.round(amount * 0.1F));
                } else {
                    attacker.damage(DamageSource.mob(defender), Math.round(amount * 0.1F));
                }
            }
            return ActionResult.PASS;
        });

        //End Gobber
        gobber_end_shield = new ModItem("gobber_end_shield", new FabricBannerShieldItem(new FabricItemSettings().maxDamage(8000).group(BasicShields.SHIELDS), 100, 30, ItemInit.GOBBER2_INGOT_END));
        gobber_end_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("gobber2", "gobber2_ingot_end"), false, new Identifier("gobber2", "gobber2_ingot_end"), false, gobber_end_shield.getIdentifier());
    }
}