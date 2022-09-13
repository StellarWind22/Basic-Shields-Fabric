package com.github.crimsondawn45.basicshields.module;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.basicshields.object.GobberShieldItem;
import com.github.crimsondawn45.basicshields.util.ContentModule;
import com.github.crimsondawn45.basicshields.util.ModItem;
import com.github.crimsondawn45.basicshields.util.ModRecipe;
import com.github.crimsondawn45.basicshields.util.ModShieldItem;
import com.github.crimsondawn45.fabricshieldlib.lib.event.ShieldBlockCallback;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GobberModule extends ContentModule {
    //Gobber Items
    public ModItem gobber_shield;
    public ModItem gobber_nether_shield;
    public ModItem gobber_end_shield;
    public ModItem gobber_dragon_shield;

    //Tags
    public TagKey<Item> gobber_tag;
    public TagKey<Item> gobber_nether_tag;
    public TagKey<Item> gobber_end_tag;
    public TagKey<Item> gobber_dragon_tag;

    public GobberModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Generic Gobber Event
        ShieldBlockCallback.EVENT.register((defender, source, amount, hand, shield) -> {

            //All gobber shields reflect damage
            if(shield.getItem() instanceof GobberShieldItem) {

                GobberShieldItem shieldInstance = (GobberShieldItem) shield.getItem();
                Entity attacker = source.getAttacker();

                //Null Check
                if(attacker == null) {
                    return ActionResult.PASS;
                }

                //Reflect damage because thats a more generic effect all gobber shields will have.
                if(defender instanceof PlayerEntity) {
                    PlayerEntity player = (PlayerEntity) defender;
                    attacker.damage(DamageSource.player(player), Math.round(amount * shieldInstance.getReflectPercentage()));
                } else {
                    attacker.damage(DamageSource.mob(defender), Math.round(amount * shieldInstance.getReflectPercentage()));
                }
            }
            return ActionResult.PASS;
        });

        //Tags
        gobber_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c","gobber_ingots"));
        gobber_nether_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c","gobber_nether_ingots"));
        gobber_end_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c","gobber_end_ingots"));
        gobber_dragon_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c","dragon_stars"));

        //Gobber
        gobber_shield = new ModShieldItem(this, "gobber_shield",
            new GobberShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.gobber_dragon_shield_durability).group(BasicShields.SHIELDS),
            BasicShields.CONFIG.gobber_shield_cooldown,
            BasicShields.CONFIG.gobber_shield_enchantability,
            BasicShields.CONFIG.gobber_reflect_percentage,
            BasicShields.CONFIG.unbreakable_gobber_shield,
            gobber_tag),
            "entity/gobber_shield_base");

        //Recipe
        this.addRecipe(gobber_shield, ModRecipe.createShieldRecipe(gobber_tag.id(), true, gobber_shield.getIdentifier()));

        //Nether Gobber
        gobber_nether_shield = new ModShieldItem(this, "gobber_nether_shield",
            new GobberShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.gobber_nether_shield_durability).group(BasicShields.SHIELDS),
            BasicShields.CONFIG.gobber_nether_shield_cooldown,
            BasicShields.CONFIG.gobber_nether_shield_enchantability,
            BasicShields.CONFIG.gobber_reflect_percentage,
            BasicShields.CONFIG.unbreakable_gobber_nether_shield,
            gobber_nether_tag),
            "entity/gobber_nether_shield_base");

        //Recipe
        this.addRecipe(gobber_nether_shield, ModRecipe.createShieldRecipe(gobber_nether_tag.id(), true, gobber_nether_shield.getIdentifier()));

        //End Gobber
        gobber_end_shield = new ModShieldItem(this, "gobber_end_shield",
            new GobberShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.gobber_end_shield_durability).group(BasicShields.SHIELDS),
            BasicShields.CONFIG.gobber_end_shield_cooldown,
            BasicShields.CONFIG.gobber_end_shield_enchantability,
            BasicShields.CONFIG.gobber_reflect_percentage,
            BasicShields.CONFIG.unbreakable_gobber_end_shield,
            gobber_end_tag),
            "entity/gobber_end_shield_base");

        //Recipe
        this.addRecipe(gobber_end_shield, ModRecipe.createShieldRecipe(gobber_end_tag.id(), true, gobber_end_shield.getIdentifier()));

        //Dragon Gobber
        gobber_dragon_shield = new ModShieldItem(this, "gobber_dragon_shield",
        new GobberShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.gobber_dragon_shield_durability).group(BasicShields.SHIELDS),
            BasicShields.CONFIG.gobber_dragon_shield_cooldown,
            BasicShields.CONFIG.gobber_dragon_shield_enchantability,
            BasicShields.CONFIG.gobber_reflect_percentage,
            BasicShields.CONFIG.unbreakable_gobber_dragon_shield,
            gobber_dragon_tag),
            "entity/gobber_dragon_shield_base");

        //Recipe
        this.addRecipe(gobber_dragon_shield, ModRecipe.createSmithingRecipe(gobber_end_shield.getIdentifier(), false, gobber_dragon_tag.id(), true, gobber_dragon_shield.getIdentifier()));
    }
}