package com.github.crimsondawn45.basicshields.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;

public class ModShieldItem extends ModItem {

    private String shieldTexurePath = null;
    private List<ModRef> modRefs = new ArrayList<ModRef>();

    /**
     * @param module ContentModule that the shield will belong to.
     * @param name Name of the shield
     * @param item Item instance of the shield
     * @param shieldTexturePath path to the shield's base texture "_nopattern" will be appended to get the other.
     */
    public ModShieldItem(ContentModule module, String name, Item item, String shieldTexturePath) {
        super(module, name, item);
        module.addShield(this);
        this.shieldTexurePath = shieldTexturePath;
    }

    /**
     * @param module ContentModule that the shield will belong to.
     * @param name Name of the shield.
     * @param item Item instance of the shield.
     * @param modReferences Collection of modReferences. Allows defining a different texture depending on the loaded mods.
     */
    public ModShieldItem(ContentModule module, String name, Item item, ModRef...modReferences) {
        super(module, name, item);
        module.addShield(this);
        this.modRefs.addAll(modRefs);
    }

    /**
     * Figure out which texture path to use
     * grabs the texture of the first reference that is loaded
     */
    public void calculateTexturePath() {

        if(this.shieldTexurePath == null) {

            for(ModRef ref : this.modRefs) {

                if(ref.isLoaded()) {
                    this.shieldTexurePath = ref.getTexturePath();
                    break;
                }
            }
        }
    }

    public String getBaseTexturePath() {
        if(this.shieldTexurePath == null) {
            this.calculateTexturePath();
        }
        return this.shieldTexurePath;
    }

    public String getNoPatternTexturePath() {
        if(this.shieldTexurePath == null) {
            this.calculateTexturePath();
        }
        return this.shieldTexurePath + "_nopattern";
    }
}
