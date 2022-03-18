package com.github.crimsondawn45.basicshields.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;

/**
 * Replace the vanilla iron shield's translation key
 */
@Mixin(ShieldItem.class)
public class ShieldItemMixin extends Item {

    private static final String TRANSLATION_KEY = "item.basicshields.iron_shield";

    public ShieldItemMixin(Settings settings) {
        super(settings);
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        if (BlockItem.getBlockEntityNbt(stack) != null) {
            return TRANSLATION_KEY + "." + ShieldItem.getColor(stack).getName();
        }
        return TRANSLATION_KEY;
    }
}
