package com.github.crimsondawn45.basicshields.object;

import com.github.crimsondawn45.basicshields.util.ContentModule;
import com.github.crimsondawn45.basicshields.util.ModShieldItem;

import net.minecraft.item.Item;

public class CopperModItem extends ModShieldItem {

    public CopperModItem(ContentModule module, String name, Item item, String normalShieldTexturePath) {
        super(module, name, item, normalShieldTexturePath);
    }

    //TODO: override these
    //clientShieldInit()
    //RegisterModelLayer()
    //setShieldEntityModel()
    //renderBanner()
}
