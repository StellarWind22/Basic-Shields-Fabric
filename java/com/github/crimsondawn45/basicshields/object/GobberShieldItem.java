package com.github.crimsondawn45.basicshields.object;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class GobberShieldItem extends FabricBannerShieldItem {

    private final boolean unbreakable;
    private final float reflectPercentage;

    public GobberShieldItem(Settings settings, int cooldownTicks, int enchantability, float reflectPercentage, boolean unbreakable, TagKey<Item> repairItemTag) {
        super(settings, cooldownTicks, enchantability, repairItemTag);
        this.unbreakable = unbreakable;
        this.reflectPercentage = reflectPercentage;
    }

    //Add reflection tooltip
    @Override
    public void appendShieldTooltip(ItemStack stack, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.basicshields.gobber.tooltip.start").append(Text.literal(String.valueOf(this.reflectPercentage * 100))).append(Text.translatable("item.basicshields.gobber.tooltip.end")).formatted(Formatting.GREEN));
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

    public float getReflectPercentage() {
        return this.reflectPercentage;
    }
}