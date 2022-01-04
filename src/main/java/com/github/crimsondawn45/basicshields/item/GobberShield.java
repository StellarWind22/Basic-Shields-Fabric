package com.github.crimsondawn45.basicshields.item;

import java.util.List;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class GobberShield extends FabricBannerShieldItem {

    private boolean unbreakable;

    public GobberShield(Settings settings, int cooldownTicks, int enchantability, boolean unbreakable, Item... repairItems) {
        super(settings, cooldownTicks, enchantability, repairItems);
        this.unbreakable = unbreakable;
    }

    //Add reflection tooltip
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.basicshields.gobber.tooltip").formatted(Formatting.GREEN));
    }

    //Make Unbreakable
    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) 
	{
		if(world.isClient) return;

		if(unbreakable)
		{
			stack.getOrCreateTag().putBoolean("Unbreakable", true);
		}
	}
}