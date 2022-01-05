package com.github.crimsondawn45.basicshields.module;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.basicshields.item.GobberShield;
import com.github.crimsondawn45.basicshields.util.ContentModule;
import com.github.crimsondawn45.basicshields.util.ModItem;
import com.github.crimsondawn45.basicshields.util.RecipeHelper;
import com.github.crimsondawn45.fabricshieldlib.lib.event.ShieldBlockCallback;
import com.google.gson.JsonObject;
import com.kwpugh.gobber2.Gobber2;
import com.kwpugh.gobber2.init.ItemInit;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;

public class GobberModule extends ContentModule {

    private static final Float GOBBER_DAMAGE_REFLECT_PERCENT = 0.2F;    //Currently at 20% reflection

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

    public GobberModule(String...requiredIds) {
        super(requiredIds);
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
                    attacker.damage(DamageSource.player(player), Math.round(amount * GOBBER_DAMAGE_REFLECT_PERCENT));
                } else {
                    attacker.damage(DamageSource.mob(defender), Math.round(amount * GOBBER_DAMAGE_REFLECT_PERCENT));
                }
            }
            return ActionResult.PASS;
        });

        //Gobber
        gobber_shield = new ModItem("gobber_shield", new GobberShield(new FabricItemSettings().maxDamage(3800).group(BasicShields.SHIELDS), 70, 20, false, ItemInit.GOBBER2_INGOT));
        gobber_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("gobber2","gobber2_ingot"), false, new Identifier("minecraft", "planks"), true, gobber_shield.getIdentifier());

        //Nether Gobber
        gobber_nether_shield = new ModItem("gobber_nether_shield", new GobberShield(new FabricItemSettings().maxDamage(5200).group(BasicShields.SHIELDS), 60, 25, false, ItemInit.GOBBER2_INGOT_NETHER));
        gobber_nether_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("gobber2","gobber2_ingot_nether"), false, new Identifier("minecraft", "planks"), true, gobber_nether_shield.getIdentifier());

        //End Gobber
        gobber_end_shield = new ModItem("gobber_end_shield", new GobberShield(new FabricItemSettings().maxDamage(8000).group(BasicShields.SHIELDS), 50, 30, Gobber2.CONFIG.GENERAL.unbreakableEndArmor, ItemInit.GOBBER2_INGOT_END));
        gobber_end_shield_recipe = RecipeHelper.createShieldRecipe(new Identifier("gobber2", "gobber2_ingot_end"), false, new Identifier("minecraft", "planks"), true, gobber_end_shield.getIdentifier());

        //Dragon Gobber
        gobber_dragon_shield = new ModItem("gobber_dragon_shield", new GobberShield(new FabricItemSettings().maxDamage(8000).group(BasicShields.SHIELDS), 50, 30, Gobber2.CONFIG.GENERAL.unbreakableDragonArmor, ItemInit.DRAGON_STAR));
        gobber_dragon_shield_recipe = RecipeHelper.createSmithingRecipe(gobber_end_shield.getIdentifier(), false, new Identifier("gobber2", "dragon_star"), false, gobber_dragon_shield.getIdentifier());
    }
}