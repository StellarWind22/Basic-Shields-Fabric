package com.github.crimsondawn45.basicshields.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

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

    @Inject(method = "getTranslationKey", at = @At("TAIL"), cancellable = true)
    private void getTranslationKey(ItemStack stack, CallbackInfoReturnable<String> info) {

        if(info.getReturnValue().startsWith("item.minecraft.shield")) {
            if (BlockItem.getBlockEntityNbt(stack) != null) {
                info.setReturnValue(TRANSLATION_KEY + "." + ShieldItem.getColor(stack).getName());
            }

            info.setReturnValue(TRANSLATION_KEY);
        }
    }
}
