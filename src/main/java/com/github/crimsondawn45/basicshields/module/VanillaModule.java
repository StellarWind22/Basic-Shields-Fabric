package com.github.crimsondawn45.basicshields.module;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.basicshields.object.BasicShieldEnchantment;
import com.github.crimsondawn45.basicshields.util.ContentModule;
import com.github.crimsondawn45.basicshields.util.ModItem;
import com.github.crimsondawn45.basicshields.util.ModRecipe;
import com.github.crimsondawn45.basicshields.util.ModShieldItem;
import com.github.crimsondawn45.fabricshieldlib.lib.event.ShieldBlockCallback;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class VanillaModule extends ContentModule {

    //Enchantments
    //Reflection - reflects percentage of damage based on level max is 75% reflection max level is 3
    public BasicShieldEnchantment reflection;
    //Curse of Vulnerability - lets 33% of the damage though the shield
    public BasicShieldEnchantment curse_of_vulnerability;

    //Regular Items
    public ModItem wooden_shield;
	public ModItem golden_shield;
	public ModItem diamond_shield;
	public ModItem netherite_shield;

    //Tags
    public TagKey<Item> gold_tag;
    public TagKey<Item> diamond_tag;
    public TagKey<Item> netherite_tag;

    @Override
    public void registerContent() {

        //Enchantments
        reflection = new BasicShieldEnchantment("reflection", Rarity.UNCOMMON, false, false, 3);
        curse_of_vulnerability = new BasicShieldEnchantment("curse_of_vulnerability", Rarity.RARE, true, true, 1);

        //Enchantment Event
        ShieldBlockCallback.EVENT.register((defender, source, amount, hand, shield) -> {

            /**
             * Handles reflection enchantment
             */
            if(reflection.hasEnchantment(shield)) {

                //Grab attacker
                Entity attacker = source.getAttacker();
                assert attacker != null;

                if(defender instanceof PlayerEntity) {  //Defender should always be a player, but check anyways
                    attacker.damage(DamageSource.player((PlayerEntity) defender), (int)Math.round(amount * (BasicShields.CONFIG.reflection_percentage_per_level * EnchantmentHelper.getLevel(reflection, shield))));
                } else {
                    attacker.damage(DamageSource.mob(defender), (int)Math.round(amount * (BasicShields.CONFIG.reflection_percentage_per_level * EnchantmentHelper.getLevel(reflection, shield))));
                }
            }

            /**
             * Handles vulnerability curse
             */
            if(curse_of_vulnerability.hasEnchantment(shield)) {

                //Grab attacker
                Entity attacker = source.getAttacker();
                assert attacker != null;

                if(attacker instanceof PlayerEntity) {
                    defender.damage(DamageSource.player((PlayerEntity) attacker), (int)Math.round(amount * BasicShields.CONFIG.curse_of_vulnerability_damage_percentage));
                } else {
                    defender.damage(DamageSource.mob((LivingEntity) attacker), (int)Math.round(amount * BasicShields.CONFIG.curse_of_vulnerability_damage_percentage));
                }
            }

            return ActionResult.PASS;
        });

        //Tags
        gold_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "gold_ingots"));
        diamond_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c","diamonds"));
        netherite_tag = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "netherite_ingots"));

        //Wood
        wooden_shield = new ModShieldItem(this, "wooden_shield",
            new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.vanilla_wooden_shield_durability).group(BasicShields.SHIELDS),
            BasicShields.CONFIG.vanilla_wooden_shield_cooldown,
            BasicShields.CONFIG.vanilla_wooden_shield_enchantability,
            ItemTags.LOGS),
            "entity/wooden_shield_base");

        //Recipe
        this.addRecipe(wooden_shield, ModRecipe.createShieldRecipe(ItemTags.LOGS.id(), true, wooden_shield.getIdentifier()));

        //Gold
		golden_shield = new ModShieldItem(this, "golden_shield",
            new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.vanilla_golden_shield_durability).group(BasicShields.SHIELDS),
            BasicShields.CONFIG.vanilla_golden_shield_cooldown,
            BasicShields.CONFIG.vanilla_golden_shield_enchantability,
            gold_tag),
            "entity/golden_shield_base");

        //Recipe
        this.addRecipe(golden_shield, ModRecipe.createShieldRecipe(gold_tag.id(), true, golden_shield.getIdentifier()));

        //Diamond
		diamond_shield = new ModShieldItem(this, "diamond_shield",
            new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.vanilla_diamond_shield_durability).group(BasicShields.SHIELDS),
            BasicShields.CONFIG.vanilla_diamond_shield_cooldown,
            BasicShields.CONFIG.vanilla_diamond_shield_enchantability,
            diamond_tag),
            "entity/diamond_shield_base");

        //Recipe
        this.addRecipe(diamond_shield, ModRecipe.createShieldRecipe(diamond_tag.id(), true, diamond_shield.getIdentifier()));

        //Netherite
		netherite_shield = new ModShieldItem(this, "netherite_shield",
            new FabricBannerShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.vanilla_netherite_shield_durability).group(BasicShields.SHIELDS).fireproof(),
            BasicShields.CONFIG.vanilla_netherite_shield_cooldown,
            BasicShields.CONFIG.vanilla_netherite_shield_enchantability,
            netherite_tag),
            "entity/netherite_shield_base");

        //Recipe
        this.addRecipe(netherite_shield, ModRecipe.createSmithingRecipe(diamond_shield.getIdentifier(), false, netherite_tag.id(), true, netherite_shield.getIdentifier()));
    }
}