package com.github.crimsondawn45.basicshields.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.advancement.AdvancementManager;

@Mixin(AdvancementManager.class)
public class AdvancementManagerMixin {
    
    //TODO: it looks like creating a virtual advancement might have more to do with code than json.
}