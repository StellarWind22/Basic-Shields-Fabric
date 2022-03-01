package com.github.crimsondawn45.basicshields.object;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.Tag.Identified;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class GobberShieldItem extends BasicShieldItem {

    private boolean unbreakable;

    public GobberShieldItem(Settings settings, int cooldownTicks, int enchantability, boolean unbreakable, Item... repairItems) {
        super(settings, cooldownTicks, enchantability, repairItems);
        this.unbreakable = unbreakable;
    }

    public GobberShieldItem(Settings settings, int cooldownTicks, int enchantability, boolean unbreakable, Identified<Item> repairItemTag) {
        super(settings, cooldownTicks, enchantability, repairItemTag);
        this.unbreakable = unbreakable;
    }

    public GobberShieldItem(Settings settings, int cooldownTicks, int enchantability, boolean unbreakable, ToolMaterial repairMaterial) {
        super(settings, cooldownTicks, repairMaterial);
        this.unbreakable = unbreakable;
    }

    public GobberShieldItem(Settings settings, int cooldownTicks, int enchantability, boolean unbreakable, List<Identified<Item>> repairItemTags) {
        super(settings, cooldownTicks, enchantability, repairItemTags);
        this.unbreakable = unbreakable;
    }

    //Add reflection tooltip
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.basicshields.gobber.tooltip.start").formatted(Formatting.GREEN));
    }

    //Make Unbreakable
    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) 
	{
		if(world.isClient) return;

		if(unbreakable)
		{
			stack.getOrCreateNbt().putBoolean("Unbreakable", true);
		}
	}
}