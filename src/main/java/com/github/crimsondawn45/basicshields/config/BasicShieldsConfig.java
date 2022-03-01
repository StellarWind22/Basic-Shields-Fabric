package com.github.crimsondawn45.basicshields.config;

import blue.endless.jankson.Comment;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "basicshields")
@Config.Gui.Background("minecraft:textures/block/dirt.png")
public class BasicShieldsConfig implements ConfigData {

    //Vanilla
    @Comment("***********************"
		    +"\nVanilla Module"
			+"\n***********************")
        //Wooden
    public int vanilla_wooden_shield_durability =           104;
    public int vanilla_wooden_shield_enchantability =       15;
    public int vanilla_wooden_shield_cooldown =             110;
        //Golden
    public int vanilla_golden_shield_durability =           44;
    public int vanilla_golden_shield_enchantability =       22;
    public int vanilla_golden_shield_cooldown =             110;
        //Diamond
    public int vanilla_diamond_shield_durability =          2098;
    public int vanilla_diamond_shield_enchantability =      10;
    public int vanilla_diamond_shield_cooldown =            110;
        //Netherite
    public int vanilla_netherite_shield_durability =        2730;
    public int vanilla_netherite_shield_enchantability =    15;
    public int vanilla_netherite_shield_cooldown =          110;

    //Adabranium
    @Comment("***********************"
		    +"\nAdabranium Module"
			+"\n***********************")
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
    @Comment("***********************"
		    +"\nBronze Module"
			+"\n***********************")
    public boolean always_load_bronze =                     false;
        //Bronze
    public int bronze_shield_durability =                   504;
    public int bronze_shield_enchantability =               6;
    public int bronze_shield_cooldown =                     100;

    //Citrine
    @Comment("***********************"
		    +"\nCitrine Module"
			+"\n***********************")
    public boolean always_load_citrine =                    false;
        //Citrine
    public int citrine_shield_durability =                   504;
    public int citrine_shield_enchantability =               6;
    public int citrine_shield_cooldown =                     100;

    //Gobber
    @Comment("***********************"
		    +"\nGobber2 Module"
			+"\n***********************")
    public boolean always_load_gobber =                     false;
    public float gobber_reflect_percentage =                0.2F;
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
    @Comment("***********************"
		    +"\nPeridot Module"
			+"\n***********************")
    public boolean always_load_peridot =                    false;

    //Ruby
    @Comment("***********************"
		    +"\nRuby Module"
			+"\n***********************")
    public boolean always_load_ruby =                       false;

    //Sapphire
    @Comment("***********************"
		    +"\nSapphire Module"
			+"\n***********************")
    public boolean always_load_sapphire =                   false;
    
}
