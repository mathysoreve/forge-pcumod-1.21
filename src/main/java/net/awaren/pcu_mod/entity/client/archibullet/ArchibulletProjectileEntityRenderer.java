package net.awaren.pcu_mod.entity.client.archibullet;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.entity.custom.ArchibulletProjectileEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ArchibulletProjectileEntityRenderer extends GeoEntityRenderer<ArchibulletProjectileEntity> {

    public ArchibulletProjectileEntityRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ArchibulletProjectileEntityModel());
    }

    @Override
    public ResourceLocation getTextureLocation(ArchibulletProjectileEntity animatable) {
        return new ResourceLocation(PCUMod.MOD_ID, "textures/entity/archibullet.png");
    }
}
