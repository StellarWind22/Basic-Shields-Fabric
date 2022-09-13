package com.github.crimsondawn45.basicshields.object;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldEnchantment;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BasicShieldEnchantment extends FabricShieldEnchantment {

    private int maxLevel;
    private String name;
    private Identifier id;

    public BasicShieldEnchantment(String name,Rarity weight, boolean isTreasure, boolean isCurse, int maxLevel) {
        super(weight, isTreasure, isCurse);
        this.maxLevel = maxLevel;
        this.name = name;
        this.id = new Identifier(BasicShields.MOD_ID, this.name);
        Registry.register(Registry.ENCHANTMENT, this.id, this);
    }

    @Override
    public int getMaxLevel() {
        return this.maxLevel;
    }

    public String getName() {
        return this.name;
    }

    public Identifier id() {
        return this.id;
    }
}
