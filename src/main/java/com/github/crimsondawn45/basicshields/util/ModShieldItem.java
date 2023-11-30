package com.github.crimsondawn45.basicshields.util;

import java.util.ArrayList;
import java.util.List;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.fabricshieldlib.initializers.FabricShieldLibClient;
import com.github.crimsondawn45.fabricshieldlib.lib.event.ShieldSetModelCallback;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;

public class ModShieldItem extends ModItem {

    private String shieldTexurePath;
    private List<ModRef> modRefs = new ArrayList<ModRef>();

    @Environment(EnvType.CLIENT)
    private EntityModelLayer entityModelLayer;
    @Environment(EnvType.CLIENT)
    private ShieldEntityModel shieldEntityModel;
    @Environment(EnvType.CLIENT)
    private SpriteIdentifier shieldBaseSprite;
    @Environment(EnvType.CLIENT)
    private SpriteIdentifier shieldNoPatternSprite;

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

        for(ModRef ref : modReferences) {
            this.modRefs.add(ref);
        }
    }

    /**
     * @param string sets the texture path
     */
    private void setTexturePath(String string) {
        this.shieldTexurePath = string.trim();
    }

    /**
     * @return texture path for the base version of the texture
     */
    @Environment(EnvType.CLIENT)
    public String getBaseTexturePath() {
        return this.shieldTexurePath;
    }

    /**
     * @return texture path for the no pattern version of the shield texuture
     */
    @Environment(EnvType.CLIENT)
    public String getNoPatternTexturePath() {
        return this.shieldTexurePath + "_nopattern";
    }

    /**
     * Figure out which texture path to use
     * grabs the texture of the first reference that is loaded
     */
    @SuppressWarnings("deprecation")
    @Environment(EnvType.CLIENT)
    public void clientShieldInit() {
        this.entityModelLayer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, this.getName()),"main");

        //Try to load a texture from the modRefs
        for(ModRef ref : this.modRefs) {

            if(ref.isLoaded()) {
                this.setTexturePath(ref.getTexturePath());
                break;
            }
        }

        //If none of the mods are loaded
        if(this.getBaseTexturePath() == null) {
            for(ModRef ref : this.modRefs) {
                this.setTexturePath(ref.getTexturePath());
                break;
            }
        }

        this.shieldBaseSprite = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID, this.getBaseTexturePath()));
        this.shieldNoPatternSprite = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID, this.getNoPatternTexturePath()));
    }

    /**
     * @return sprite identifier for no pattern version of the shield texture
     */
    public SpriteIdentifier getBaseSpriteIdentifier() {
        return this.shieldBaseSprite;
    }

    /**
     * @return sprite identifier for no pattern version of the shield texture
     */
    public SpriteIdentifier getNoPatternSpriteIdentifier() {
        return this.shieldNoPatternSprite;
    }

    @Environment(EnvType.CLIENT)
    public EntityModelLayer getEntityModelLayer() {
        return this.entityModelLayer;
    }

    /**
     * Handles setting the shieldEntity model
     * @param modelLoader an instance of the entiyModelLoader.
     */
    @Environment(EnvType.CLIENT)
    public void setShieldEntityModel(EntityModelLoader modelLoader) {
        this.shieldEntityModel = new ShieldEntityModel(modelLoader.getModelPart(this.getEntityModelLayer()));
    }

    /**
     * @return the shieldEntityModel
     */
    @Environment(EnvType.CLIENT)
    public ShieldEntityModel getShieldEntityModel() {
        return this.shieldEntityModel;
    }

     /**
     * Handles registering the model layer & setting up the client sprite registry callback
     */
    @Environment(EnvType.CLIENT)
    public void RegisterModelLayer(){
        EntityModelLayerRegistry.registerModelLayer(this.getEntityModelLayer(), ShieldEntityModel::getTexturedModelData);

        //Set model
        ShieldSetModelCallback.EVENT.register((loader) -> {
            this.shieldEntityModel = new ShieldEntityModel(loader.getModelPart(this.getEntityModelLayer()));
            return ActionResult.PASS;
        });
    }

    /**
     * Handles rendering the banner for the shield
     * @param stack ItemStack of the shield
     * @param matrices matrix stack
     * @param vertexConsumers vertex consumers
     * @param light light level
     * @param overlay overlay
     */
    @Environment(EnvType.CLIENT)
    public void renderBanner(ItemStack stack, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

        if(stack.isOf(this.getItem())) {
            FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, this.getShieldEntityModel(), this.getBaseSpriteIdentifier(), this.getNoPatternSpriteIdentifier());
        }
    }
}
