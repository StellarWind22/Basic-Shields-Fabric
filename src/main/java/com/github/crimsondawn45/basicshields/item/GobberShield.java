package com.github.crimsondawn45.basicshields.item;

import java.util.List;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class GobberShield extends FabricBannerShieldItem {

    public GobberShield(Settings settings, int cooldownTicks, int enchantability, Item... repairItems) {
        super(settings, cooldownTicks, enchantability, repairItems);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        
        //Add reflection tooltip
        tooltip.add(new TranslatableText("item.basicshields.gobber.tooltip").formatted(Formatting.GREEN));
    }
}