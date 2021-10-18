package net.fabricmc.example;

import com.github.crimsondawn45.fabricshieldlib.lib.event.ShieldBlockCallback;
import com.github.crimsondawn45.fabricshieldlib.lib.event.ShieldDisabledCallback;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldEnchantment;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("modid");

	public static final Item TEST_SHIELD = new FabricShieldItem(new FabricItemSettings().maxDamage(2500).group(ItemGroup.COMBAT), 100, 9, Items.OAK_PLANKS); // FabricShieldItem(settings.maxDamage(durability), cooldownTicks, enchantability, repairItem)

	public static final Item TEST_SHIELD_WITH_BANNER_SUPPORT = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(2500).group(ItemGroup.COMBAT), 100, 9, Items.OAK_PLANKS); // FabricBannerShieldItem(settings.maxDamage(durability), cooldownTicks, enchantability, repairItem)

	public static final EntityModelLayer TEST_SHIELD_MODEL_LAYER = new EntityModelLayer(new Identifier("examplemod", "test_shield"),"main");

	public static final FabricShieldEnchantment TEST_ENCHANTMENT = new FabricShieldEnchantment(Rarity.COMMON);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registry.ITEM, new Identifier("examplemod", "test_shield"), TEST_SHIELD);

		Registry.register(Registry.ITEM, new Identifier("examplemod", "test_shield_with_banner_support"), TEST_SHIELD_WITH_BANNER_SUPPORT);

		Registry.register(Registry.ENCHANTMENT, new Identifier("examplemod", "test_enchantment"), TEST_ENCHANTMENT);

		/*
		 * Test event: makes any shield with new enchantment reflect 1/3rd of damage back to attacker
		 */
		ShieldBlockCallback.EVENT.register((defender, source, amount, hand, shield) -> {

			if(TEST_ENCHANTMENT.hasEnchantment(shield)) {
				Entity attacker = source.getAttacker();

				assert attacker != null;
				if(defender instanceof PlayerEntity) {  //Defender should always be a player, but check anyways
					attacker.damage(DamageSource.player((PlayerEntity) defender), (int)Math.round(amount * 0.33F));
				} else {
					attacker.damage(DamageSource.mob(defender), (int)Math.round(amount * 0.33F));
				}
			}

			return ActionResult.PASS;
		});

		/*
		 * Test Event: if your shield gets disabled give player speed
		 */
		ShieldDisabledCallback.EVENT.register((defender, hand, shield) -> {
			defender.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 10, 1, true, false));
			return ActionResult.PASS;
		});

		LOGGER.info("Hello Fabric world!");
	}
}
