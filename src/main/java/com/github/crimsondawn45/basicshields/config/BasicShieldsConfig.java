package com.github.crimsondawn45.basicshields.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "basicshields")
@Config.Gui.CategoryBackground(category = "modules", background = "minecraft:textures/block/dirt.png")
@Config.Gui.CategoryBackground(category = "stats", background = "minecraft:textures/block/dirt.png")
@Config.Gui.CategoryBackground(category = "textures", background = "minecraft:textures/block/dirt.png")
public class BasicShieldsConfig implements ConfigData {

    //Vanilla
        //Wooden
    @ConfigEntry.Category("stats")
    public int vanilla_wooden_shield_durability =           104;
    @ConfigEntry.Category("stats")
    public int vanilla_wooden_shield_enchantability =       15;
    @ConfigEntry.Category("stats")
    public int vanilla_wooden_shield_cooldown =             120;
        //Golden
    @ConfigEntry.Category("stats")
    public int vanilla_golden_shield_durability =           44;
    @ConfigEntry.Category("stats")
    public int vanilla_golden_shield_enchantability =       22;
    @ConfigEntry.Category("stats")
    public int vanilla_golden_shield_cooldown =             100;
        //Diamond
    @ConfigEntry.Category("stats")
    public int vanilla_diamond_shield_durability =          2098;
    @ConfigEntry.Category("stats")
    public int vanilla_diamond_shield_enchantability =      10;
    @ConfigEntry.Category("stats")
    public int vanilla_diamond_shield_cooldown =            90;
        //Netherite
    @ConfigEntry.Category("stats")
    public int vanilla_netherite_shield_durability =        2730;
    @ConfigEntry.Category("stats")
    public int vanilla_netherite_shield_enchantability =    15;
    @ConfigEntry.Category("stats")
    public int vanilla_netherite_shield_cooldown =          80;

    //Adabranium
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_adabranium =                 false;
        //Nether
    @ConfigEntry.Category("stats")
    public int adabranium_nether_shield_durability =        511;
    @ConfigEntry.Category("stats")
    public int adabranium_nether_shield_enchantability =    15;
    @ConfigEntry.Category("stats")
    public int adabranium_nether_shield_cooldown =          100;
        //Vibranium
    @ConfigEntry.Category("stats")
    public int adabranium_vibranium_shield_durability =     4019;
    @ConfigEntry.Category("stats")
    public int adabranium_vibranium_shield_enchantability = 12;
    @ConfigEntry.Category("stats")
    public int adabranium_vibranium_shield_cooldown =       70;
        //Adamantium
    @ConfigEntry.Category("stats")
    public int adabranium_adamantium_shield_durability =    5753;
    @ConfigEntry.Category("stats")
    public int adabranium_adamantium_shield_enchantability= 10;
    @ConfigEntry.Category("stats")
    public int adabranium_adamantium_shield_cooldown =      60;

    //Gobber
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_gobber =                     false;
    @ConfigEntry.Category("stats")
    public float gobber_reflect_percentage =                0.2F;
        //Overworld
    @ConfigEntry.Category("stats")
    public boolean unbreakable_gobber_shield =              false;
    @ConfigEntry.Category("stats")
    public int gobber_shield_durability =                   5108;
    @ConfigEntry.Category("stats")
    public int gobber_shield_enchantability =               20;
    @ConfigEntry.Category("stats")
    public int gobber_shield_cooldown =                     70;
        //Nether
    @ConfigEntry.Category("stats")
    public boolean unbreakable_gobber_nether_shield =       false;
    @ConfigEntry.Category("stats")
    public int gobber_nether_shield_durability =            6989;
    @ConfigEntry.Category("stats")
    public int gobber_nether_shield_enchantability =        25;
    @ConfigEntry.Category("stats")
    public int gobber_nether_shield_cooldown =              60;
        //End
    @ConfigEntry.Category("stats")
    public boolean unbreakable_gobber_end_shield =          true;
    @ConfigEntry.Category("stats")
    public int gobber_end_shield_durability =               10752;
    @ConfigEntry.Category("stats")
    public int gobber_end_shield_enchantability =           30;
    @ConfigEntry.Category("stats")
    public int gobber_end_shield_cooldown =                 50;
        //Dragon
    @ConfigEntry.Category("stats")
    public boolean unbreakable_gobber_dragon_shield =       true;
    @ConfigEntry.Category("stats")
    public int gobber_dragon_shield_durability =            10752;
    @ConfigEntry.Category("stats")
    public int gobber_dragon_shield_enchantability =        30;
    @ConfigEntry.Category("stats")
    public int gobber_dragon_shield_cooldown =              40;

    //Aether
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_aether =                     false;
        //Zanite
    @ConfigEntry.Category("stats")
    public int zanite_shield_durability =                   336;
    @ConfigEntry.Category("stats")
    public int zanite_shield_enchantability =               14;
    @ConfigEntry.Category("stats")
    public int zanite_shield_cooldown =                     100;
        //Candy
    @ConfigEntry.Category("stats")
    public int candy_shield_durability =                    699;
    @ConfigEntry.Category("stats")
    public int candy_shield_enchantability =                12;
    @ConfigEntry.Category("stats")
    public int candy_shield_cooldown =                      100;
        //Gravitite
    @ConfigEntry.Category("stats")
    public int gravitite_shield_durability =                2098;
    @ConfigEntry.Category("stats")
    public int gravitite_shield_enchantability =            10;
    @ConfigEntry.Category("stats")
    public int gravitite_shield_cooldown =                  100;
        //Valkyrie
    @ConfigEntry.Category("stats")
    public int valkyrie_shield_durability =                 2909;
    @ConfigEntry.Category("stats")
    public int valkyrie_shield_enchantability =             8;
    @ConfigEntry.Category("stats")
    public int valkyrie_shield_cooldown =                   100;
        //Legendary
    @ConfigEntry.Category("stats")
    public int legendary_shield_durability =                2909;
    @ConfigEntry.Category("stats")
    public int legendary_shield_enchantability =            8;
    @ConfigEntry.Category("stats")
    public int legendary_shield_cooldown =                  100;

    //Bronze
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_bronze =                     false;
        //Bronze
    @ConfigEntry.Category("stats")
    public int bronze_shield_durability =                   504;
    @ConfigEntry.Category("stats")
    public int bronze_shield_enchantability =               6;
    @ConfigEntry.Category("stats")
    public int bronze_shield_cooldown =                     100;

    //Citrine
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_citrine =                    false;
        //Citrine
    @ConfigEntry.Category("stats")
    public int citrine_shield_durability =                  1109;
    @ConfigEntry.Category("stats")
    public int citrine_shield_enchantability =              14;
    @ConfigEntry.Category("stats")
    public int citrine_shield_cooldown =                    95;

    //Tourmaline
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_tourmaline =                 false;
        //Tourmaline
    @ConfigEntry.Category("stats")
    public int tourmaline_shield_durability =               1258;
    @ConfigEntry.Category("stats")
    public int tourmaline_shield_enchantability =           14;
    @ConfigEntry.Category("stats")
    public int tourmaline_shield_cooldown =                 95;

    //Kunzite
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_kunzite =                    false;
        //Kunzite
    @ConfigEntry.Category("stats")
    public int kunzite_shield_durability =                  1468;
    @ConfigEntry.Category("stats")
    public int kunzite_shield_enchantability =              14;
    @ConfigEntry.Category("stats")
    public int kunzite_shield_cooldown =                    95;

    //Topaz
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_topaz =                      false;
        //Topaz
    @ConfigEntry.Category("stats")
    public int topaz_shield_durability =                    1678;
    @ConfigEntry.Category("stats")
    public int topaz_shield_enchantability =                14;
    @ConfigEntry.Category("stats")
    public int topaz_shield_cooldown =                      95;

    //Alexandrite
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_alexandrite =                false;
        //Alexandrite
    @ConfigEntry.Category("stats")
    public int alexandrite_shield_durability =              1783;
    @ConfigEntry.Category("stats")
    public int alexandrite_shield_enchantability =          14;
    @ConfigEntry.Category("stats")
    public int alexandrite_shield_cooldown =                95;

    //Corundum
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_corundum =                   false;
        //Corundum
    @ConfigEntry.Category("stats")
    public int corundum_shield_durability =                 1887;
    @ConfigEntry.Category("stats")
    public int corundum_shield_enchantability =             14;
    @ConfigEntry.Category("stats")
    public int corundum_shield_cooldown =                   95;

    //Spinel
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_spinel =                     false;
        //Spinel
    @ConfigEntry.Category("stats")
    public int spinel_shield_durability =                   1887;
    @ConfigEntry.Category("stats")
    public int spinel_shield_enchantability =               14;
    @ConfigEntry.Category("stats")
    public int spinel_shield_cooldown =                     95;

    //Carbonado
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_carbonado =                  false;
        //Carbonado
    @ConfigEntry.Category("stats")
    public int carbonado_shield_durability =                2098;
    @ConfigEntry.Category("stats")
    public int carbonado_shield_enchantability =            24;
    @ConfigEntry.Category("stats")
    public int carbonado_shield_cooldown =                  90;

    //Moissanite
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_moissanite =                 false;
        //Moissanite
    @ConfigEntry.Category("stats")
    public int moissanite_shield_durability =               2730;
    @ConfigEntry.Category("stats")
    public int moissanite_shield_enchantability =           24;
    @ConfigEntry.Category("stats")
    public int moissanite_shield_cooldown =                 90;

    //Emerald
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_emerald =                    false;
        //Emerald
    @ConfigEntry.Category("stats")
    public int emerald_shield_durability =                  975;
    @ConfigEntry.Category("stats")
    public int emerald_shield_enchantability =              10;
    @ConfigEntry.Category("stats")
    public int emerald_shield_cooldown =                    95;

    //Obsidian
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_obsidian =                   false;
        //Obsidian
    @ConfigEntry.Category("stats")
    public int obsidian_shield_durability =                 874;
    @ConfigEntry.Category("stats")
    public int obsidian_shield_enchantability =             4;
    @ConfigEntry.Category("stats")
    public int obsidian_shield_cooldown =                   110;

    //Steel
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_steel =                      false;
        //Steel
    @ConfigEntry.Category("stats")
    public int steel_shield_durability =                    689;
    @ConfigEntry.Category("stats")
    public int steel_shield_enchantability =                9;
    @ConfigEntry.Category("stats")
    public int steel_shield_cooldown =                      100;

    //Tanzanite
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_tanzanite =                    false;
        //Tanzanite
    @ConfigEntry.Category("stats")
    public int tanzanite_shield_durability =                  1008;
    @ConfigEntry.Category("stats")
    public int tanzanite_shield_enchantability =              20;
    @ConfigEntry.Category("stats")
    public int tanzanite_shield_cooldown =                    95;

    //Amethyst
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_amethyst =                   false;
        //Amethyst
    @ConfigEntry.Category("stats")
    public int amethyst_shield_durability =                 1129;
    @ConfigEntry.Category("stats")
    public int amethyst_shield_enchantability =             25;
    @ConfigEntry.Category("stats")
    public int amethyst_shield_cooldown =                   95;

    //Copper
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_copper =                     false;
        //Copper
    @ConfigEntry.Category("stats")
    public int copper_shield_durability =                   336;
    @ConfigEntry.Category("stats")
    public int copper_shield_enchantability =               18;
    @ConfigEntry.Category("stats")
    public int copper_shield_cooldown =                     105;

    //Peridot
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_peridot =                    false;
        //Peridot
    @ConfigEntry.Category("stats")
    public int peridot_shield_durability =                  1008;
    @ConfigEntry.Category("stats")
    public int peridot_shield_enchantability =              12;
    @ConfigEntry.Category("stats")
    public int peridot_shield_cooldown =                    90;

    //Quartz
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_quartz =                    false;
        //Quartz
    @ConfigEntry.Category("stats")
    public int quartz_shield_durability =                  538;
    @ConfigEntry.Category("stats")
    public int quartz_shield_enchantability =              9;
    @ConfigEntry.Category("stats")
    public int quartz_shield_cooldown =                    95;

    //Ruby
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_ruby =                       false;
        //Ruby
    @ConfigEntry.Category("stats")
    public int ruby_shield_durability =                     1008;
    @ConfigEntry.Category("stats")
    public int ruby_shield_enchantability =                 10;
    @ConfigEntry.Category("stats")
    public int ruby_shield_cooldown =                       95;

    //Sapphire
    @Comment("Module will always be loaded. Crafting will be\ndisabled if it was not a vanilla material\nas to not spam errors for missing items.")
    @ConfigEntry.Category("modules")
    public boolean always_load_sapphire =                   false;
        //Sapphire
    @ConfigEntry.Category("stats")
    public int sapphire_shield_durability =                 1344;
    @ConfigEntry.Category("stats")
    public int sapphire_shield_enchantability =             12;
    @ConfigEntry.Category("stats")
    public int sapphire_shield_cooldown =                   95;
}
