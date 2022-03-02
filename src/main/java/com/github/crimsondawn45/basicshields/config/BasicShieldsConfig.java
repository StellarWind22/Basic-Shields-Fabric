package com.github.crimsondawn45.basicshields.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "basicshields")
@Config.Gui.Background("minecraft:textures/block/dirt.png")
public class BasicShieldsConfig implements ConfigData {

    //Vanilla
        //Wooden
    public int vanilla_wooden_shield_durability =           104;
    public int vanilla_wooden_shield_enchantability =       15;
    public int vanilla_wooden_shield_cooldown =             110;
        //Golden
    public int vanilla_golden_shield_durability =           44;
    public int vanilla_golden_shield_enchantability =       22;
    public int vanilla_golden_shield_cooldown =             100;
        //Diamond
    public int vanilla_diamond_shield_durability =          2098;
    public int vanilla_diamond_shield_enchantability =      10;
    public int vanilla_diamond_shield_cooldown =            90;
        //Netherite
    public int vanilla_netherite_shield_durability =        2730;
    public int vanilla_netherite_shield_enchantability =    15;
    public int vanilla_netherite_shield_cooldown =          80;

    //Adabranium
    @Comment("Force loads module crafting recipes will not be ingame")
    public boolean always_load_adabranium =                 false;
        //Nether
    public int adabranium_nether_shield_durability =        511;
    public int adabranium_nether_shield_enchantability =    15;
    public int adabranium_nether_shield_cooldown =          100;
        //Vibranium
    public int adabranium_vibranium_shield_durability =     4019;
    public int adabranium_vibranium_shield_enchantability = 12;
    public int adabranium_vibranium_shield_cooldown =       70;
        //Adamantium
    public int adabranium_adamantium_shield_durability =    5753;
    public int adabranium_adamantium_shield_enchantability= 10;
    public int adabranium_adamantium_shield_cooldown =      70;

    //Bronze
    @Comment("Force loads module crafting recipes will not be ingame")
    public boolean always_load_bronze =                     false;
        //Bronze
    public int bronze_shield_durability =                   504;
    public int bronze_shield_enchantability =               6;
    public int bronze_shield_cooldown =                     100;

    //Citrine
    @Comment("Force loads module crafting recipes will not be ingame")
    public boolean always_load_citrine =                    false;
        //Citrine
    public int citrine_shield_durability =                  1109;
    public int citrine_shield_enchantability =              14;
    public int citrine_shield_cooldown =                    90;

    //Tourmaline
    @Comment("Force loads module crafting recipes will not be ingame")
    public boolean always_load_tourmaline =                 false;
        //Tourmaline
    public int tourmaline_shield_durability =               1258;
    public int tourmaline_shield_enchantability =           14;
    public int tourmaline_shield_cooldown =                 90;

    //Kunzite
    @Comment("Force loads module crafting recipes will not be ingame")
    public boolean always_load_kunzite =                    false;
        //Kunzite
    public int kunzite_shield_durability =                  1468;
    public int kunzite_shield_enchantability =              14;
    public int kunzite_shield_cooldown =                    90;

    //Topaz
    @Comment("Force loads module crafting recipes will not be ingame")
    public boolean always_load_topaz =                      false;
        //Topaz
    public int topaz_shield_durability =                    1678;
    public int topaz_shield_enchantability =                14;
    public int topaz_shield_cooldown =                      90;

    //Alexandrite
    @Comment("Force loads module crafting recipes will not be ingame")
    public boolean always_load_alexandrite =                false;
        //Alexandrite
    public int alexandrite_shield_durability =              1783;
    public int alexandrite_shield_enchantability =          14;
    public int alexandrite_shield_cooldown =                90;

    //Corundum
    @Comment("Force loads module crafting recipes will not be ingame")
    public boolean always_load_corundum =                   false;
        //Corundum
    public int corundum_shield_durability =                 1887;
    public int corundum_shield_enchantability =             14;
    public int corundum_shield_cooldown =                   90;

    //Spinel
    @Comment("Force loads module crafting recipes will not be ingame")
    public boolean always_load_spinel =                     false;
        //Spinel
    public int spinel_shield_durability =                   1887;
    public int spinel_shield_enchantability =               14;
    public int spinel_shield_cooldown =                     90;

    //Carbonado
    @Comment("Force loads module crafting recipes will not be ingame")
    public boolean always_load_carbonado =                  false;
        //Carbonado
    public int carbonado_shield_durability =                2098;
    public int carbonado_shield_enchantability =            24;
    public int carbonado_shield_cooldown =                  90;

    //Moissanite
    @Comment("Force loads module crafting recipes will not be ingame")
    public boolean always_load_moissanite =                 false;
        //Moissanite
    public int moissanite_shield_durability =               2730;
    public int moissanite_shield_enchantability =           24;
    public int moissanite_shield_cooldown =                 90;

    //Emerald
    @Comment("Force loads module crafting recipes will not be ingame")
    public boolean always_load_emerald =                    false;
        //Emerald
    public int emerald_shield_durability =                  975;
    public int emerald_shield_enchantability =              10;
    public int emerald_shield_cooldown =                    100;

    //Obsidian
    @Comment("Force loads module crafting recipes will not be ingame")
    public boolean always_load_obsidian =                   false;
        //Obsidian
    public int obsidian_shield_durability =                 874;
    public int obsidian_shield_enchantability =             4;
    public int obsidian_shield_cooldown =                   100;

    //Steel
    @Comment("Force loads module crafting recipes will not be ingame")
    public boolean always_load_steel =                      false;
        //Steel
    public int steel_shield_durability =                    689;
    public int steel_shield_enchantability =                9;
    public int steel_shield_cooldown =                      100;

    //Tanzanite
    @Comment("Force loads module crafting recipes will not be ingame")
    public boolean always_load_tanzanite =                    false;
        //Tanzanite
    public int tanzanite_shield_durability =                  1008;
    public int tanzanite_shield_enchantability =              20;
    public int tanzanite_shield_cooldown =                    90;

    //Amethyst
    @Comment("Force loads module crafting recipes will not be ingame")
    public boolean always_load_amethyst =                   false;
        //Amethyst
    public int amethyst_shield_durability =                 1129;
    public int amethyst_shield_enchantability =             25;
    public int amethyst_shield_cooldown =                   100;

    //Copper
    @Comment("Force loads module crafting recipes will not be ingame")
    public boolean always_load_copper =                     false;
        //Copper
    public int copper_shield_durability =                   336;
    public int copper_shield_enchantability =               18;
    public int copper_shield_cooldown =                     100;

    //Gobber
    @Comment("Force loads module crafting recipes will not be ingame")
    public boolean always_load_gobber =                     false;
    public float gobber_reflect_percentage =                0.2F;       //TODO: make the tooltip match current setting
        //Overworld
    public boolean unbreakable_gobber_shield =              false;
    public int gobber_shield_durability =                   5108;
    public int gobber_shield_enchantability =               20;
    public int gobber_shield_cooldown =                     70;
        //Nether
    public boolean unbreakable_gobber_nether_shield =       false;
    public int gobber_nether_shield_durability =            6989;
    public int gobber_nether_shield_enchantability =        25;
    public int gobber_nether_shield_cooldown =              60;
        //End
    public boolean unbreakable_gobber_end_shield =          true;
    public int gobber_end_shield_durability =               10752;
    public int gobber_end_shield_enchantability =           30;
    public int gobber_end_shield_cooldown =                 50;
        //Dragon
    public boolean unbreakable_gobber_dragon_shield =       true;
    public int gobber_dragon_shield_durability =            10752;
    public int gobber_dragon_shield_enchantability =        30;
    public int gobber_dragon_shield_cooldown =              50;

    //Peridot
    @Comment("Force loads module crafting recipes will not be ingame")
    public boolean always_load_peridot =                    false;
        //Peridot
    public int peridot_shield_durability =                  1008;
    public int peridot_shield_enchantability =              12;
    public int peridot_shield_cooldown =                    90;

    //Quartz
    @Comment("Force loads module crafting recipes will not be ingame")
    public boolean always_load_quartz =                    false;
        //Quartz
    public int quartz_shield_durability =                  538;
    public int quartz_shield_enchantability =              9;
    public int quartz_shield_cooldown =                    90;

    //Ruby
    @Comment("Force loads module crafting recipes will not be ingame")
    public boolean always_load_ruby =                       false;
        //Ruby
    public int ruby_shield_durability =                     1008;
    public int ruby_shield_enchantability =                 10;
    public int ruby_shield_cooldown =                       90;

    //Sapphire
    @Comment("Force loads module crafting recipes will not be ingame")
    public boolean always_load_sapphire =                   false;
        //Sapphire
    public int sapphire_shield_durability =                 1344;
    public int sapphire_shield_enchantability =             12;
    public int sapphire_shield_cooldown =                   90;
}
