package com.github.crimsondawn45.basicshields.util;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItem {

    private String name;
    private Identifier identifier;
    private Item item;
    private ContentModule module;

    public ModItem(ContentModule module, String name, Item item) {
        this.module = module;
        this.name = name;
        this.identifier = new Identifier(BasicShields.MOD_ID, name);
        this.item = item;

        Registry.register(Registries.ITEM, this.identifier, this.item);
    }

    public Item getItem() {
        return this.item;
    }

    public Identifier getIdentifier() {
        return this.identifier;
    }

    public String getName() {
        return this.name;
    }

    public ContentModule getModule() {
        return this.module;
    }
}