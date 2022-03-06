package com.github.crimsondawn45.basicshields.object;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.basicshields.util.ContentModule;
import com.github.crimsondawn45.basicshields.util.ModShieldItem;
import com.github.crimsondawn45.fabricshieldlib.initializers.FabricShieldLibClient;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class CopperModItem extends ModShieldItem {

    //Texture paths
    private String exposedShieldTexurePath;
    private String weatheredShieldTexurePath;
    private String oxidizedShieldTexurePath;

    @Environment(EnvType.CLIENT)
    private ShieldEntityModel normalEntityModel;
    @Environment(EnvType.CLIENT)
    private ShieldEntityModel exposedEntityModel;
    @Environment(EnvType.CLIENT)
    private ShieldEntityModel weatheredEntityModel;
    @Environment(EnvType.CLIENT)
    private ShieldEntityModel oxidizedEntityModel;

    //Model Layers
    @Environment(EnvType.CLIENT)
    protected EntityModelLayer normalEntityModelLayer;
    @Environment(EnvType.CLIENT)
    protected EntityModelLayer exposedEntityModelLayer;
    @Environment(EnvType.CLIENT)
    protected EntityModelLayer weatheredEntityModelLayer;
    @Environment(EnvType.CLIENT)
    protected EntityModelLayer oxidizedEntityModelLayer;

    //Sprite Identifiers
    @Environment(EnvType.CLIENT)
    private SpriteIdentifier normalShieldBaseSprite;
    @Environment(EnvType.CLIENT)
    private SpriteIdentifier normalShieldNoPatternSprite;
    @Environment(EnvType.CLIENT)
    private SpriteIdentifier exposedShieldBaseSprite;
    @Environment(EnvType.CLIENT)
    private SpriteIdentifier exposedShieldNoPatternSprite;
    @Environment(EnvType.CLIENT)
    private SpriteIdentifier weatheredShieldBaseSprite;
    @Environment(EnvType.CLIENT)
    private SpriteIdentifier weatheredShieldNoPatternSprite;
    @Environment(EnvType.CLIENT)
    private SpriteIdentifier oxidizedShieldBaseSprite;
    @Environment(EnvType.CLIENT)
    private SpriteIdentifier oxidizedShieldNoPatternSprite;

    public CopperModItem(ContentModule module, String name, Item item, String normalShieldTexturePath, String exposedShieldTexturePath, String weatheredShieldTexturePath, String oxidizedShieldTexturePath) {
        super(module, name, item, normalShieldTexturePath);
        this.exposedShieldTexurePath = exposedShieldTexturePath;
        this.weatheredShieldTexurePath = exposedShieldTexturePath;
        this.oxidizedShieldTexurePath = exposedShieldTexturePath;
    }

    @Override
    @SuppressWarnings("deprecation")
    @Environment(EnvType.CLIENT)
    public void clientShieldInit() {
        
        //Entity Model Layer
        this.normalEntityModelLayer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, this.getName() + "_normal"),"main");
        this.exposedEntityModelLayer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, this.getName() + "_exposed"),"main");
        this.weatheredEntityModelLayer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, this.getName() + "_weathered"),"main");
        this.oxidizedEntityModelLayer = new EntityModelLayer(new Identifier(BasicShields.MOD_ID, this.getName() + "_oxidized"),"main");

        //Load the sprites
        this.normalShieldBaseSprite = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID, this.getBaseTexturePath()));
        this.normalShieldNoPatternSprite = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(BasicShields.MOD_ID, this.getNoPatternTexturePath()));
        this.exposedShieldBaseSprite = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(this.exposedShieldTexurePath));
        this.exposedShieldNoPatternSprite = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(this.exposedShieldTexurePath + "_nopattern"));
        this.weatheredShieldBaseSprite = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(this.weatheredShieldTexurePath));
        this.weatheredShieldNoPatternSprite = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(this.weatheredShieldTexurePath + "_nopattern"));
        this.oxidizedShieldBaseSprite = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(this.oxidizedShieldTexurePath));
        this.oxidizedShieldNoPatternSprite = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(this.oxidizedShieldTexurePath + "_nopattern"));
    }

    @Override
    @SuppressWarnings("deprecation")
    @Environment(EnvType.CLIENT)
    public void RegisterModelLayer(){

        //Normal
        EntityModelLayerRegistry.registerModelLayer(this.normalEntityModelLayer, ShieldEntityModel::getTexturedModelData);

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier(BasicShields.MOD_ID, this.getBaseTexturePath()));
            registry.register(new Identifier(BasicShields.MOD_ID, this.getNoPatternTexturePath()));
        });

        //Exposed
        EntityModelLayerRegistry.registerModelLayer(this.exposedEntityModelLayer, ShieldEntityModel::getTexturedModelData);

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier(BasicShields.MOD_ID, this.exposedShieldTexurePath));
            registry.register(new Identifier(BasicShields.MOD_ID, this.exposedShieldTexurePath + "_nopattern"));
        });

        //Weathered
        EntityModelLayerRegistry.registerModelLayer(this.weatheredEntityModelLayer, ShieldEntityModel::getTexturedModelData);

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier(BasicShields.MOD_ID, this.weatheredShieldTexurePath));
            registry.register(new Identifier(BasicShields.MOD_ID, this.weatheredShieldTexurePath + "_nopattern"));
        });

        //Oxidized
        EntityModelLayerRegistry.registerModelLayer(this.oxidizedEntityModelLayer, ShieldEntityModel::getTexturedModelData);

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier(BasicShields.MOD_ID, this.oxidizedShieldTexurePath));
            registry.register(new Identifier(BasicShields.MOD_ID, this.oxidizedShieldTexurePath + "_nopattern"));
        });
    }

    /**
     * Handles setting the shieldEntity model
     * @param modelLoader an instance of the entiyModelLoader.
     */
    @Override
    @Environment(EnvType.CLIENT)
    public void setShieldEntityModel(EntityModelLoader modelLoader) {
        this.normalEntityModel = new ShieldEntityModel(modelLoader.getModelPart(this.normalEntityModelLayer));
        this.exposedEntityModel = new ShieldEntityModel(modelLoader.getModelPart(this.exposedEntityModelLayer));
        this.weatheredEntityModel = new ShieldEntityModel(modelLoader.getModelPart(this.weatheredEntityModelLayer));
        this.oxidizedEntityModel = new ShieldEntityModel(modelLoader.getModelPart(this.oxidizedEntityModelLayer));
    }
    
    /**
     * Handles rendering the banner for the shield
     * @param stack ItemStack of the shield
     * @param matrices matrix stack
     * @param vertexConsumers vertex consumers
     * @param light light level
     * @param overlay overlay
     */
    @Override
    @Environment(EnvType.CLIENT)
    public void renderBanner(ItemStack stack, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

        if(stack.isOf(this.getItem())) {

            int durability = stack.getMaxDamage() - stack.getDamage();

            /**
             * If durability is greater than to 75% display shield as normal
             * 
             * 100% -> 75%
             */
            if(durability > (stack.getMaxDamage() * 0.75F)) {
                FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, this.normalEntityModel, this.normalShieldBaseSprite, this.normalShieldNoPatternSprite);
            }

            /**
             * If durability less than 75%, but greater than 50% display as exposed
             */
            if(durability <= (stack.getMaxDamage() * 0.75F) && durability > (stack.getMaxDamage() * 0.50F)) {
                FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, this.exposedEntityModel, this.exposedShieldBaseSprite, this.exposedShieldNoPatternSprite);
            }

            /**
             * If durability less than 50%, but greater than 25% display as weathered
             */
            if(durability <= (stack.getMaxDamage() * 0.50F) && durability > (stack.getMaxDamage() * 0.25F)) {
                FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, this.weatheredEntityModel, this.weatheredShieldBaseSprite, this.weatheredShieldNoPatternSprite);
            }

            /**
             * If durability less than 25% display as oxidized.
             */
            if(durability <= (stack.getMaxDamage() * 0.25F)) {
                FabricShieldLibClient.renderBanner(stack, matrices, vertexConsumers, light, overlay, this.oxidizedEntityModel, this.oxidizedShieldBaseSprite, this.oxidizedShieldNoPatternSprite);
            }
        }
    }
}
