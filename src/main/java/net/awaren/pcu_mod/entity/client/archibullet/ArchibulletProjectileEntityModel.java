package net.awaren.pcu_mod.entity.client.archibullet;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.entity.custom.ArchibulletProjectileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ArchibulletProjectileEntityModel extends GeoModel<ArchibulletProjectileEntity> {


    @Override
    public ResourceLocation getModelResource(ArchibulletProjectileEntity archibulletProjectileEntity) {
        return new ResourceLocation(PCUMod.MOD_ID, "geo/archibullet.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ArchibulletProjectileEntity archibulletProjectileEntity) {
        return new ResourceLocation(PCUMod.MOD_ID, "textures/entity/archibullet.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ArchibulletProjectileEntity archibulletProjectileEntity) {
        return new ResourceLocation(PCUMod.MOD_ID, "animations/archibullet.animation.json");
    }
}
