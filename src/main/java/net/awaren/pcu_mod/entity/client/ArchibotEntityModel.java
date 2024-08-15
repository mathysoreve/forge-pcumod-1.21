package net.awaren.pcu_mod.entity.client;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.entity.custom.ArchibotEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class ArchibotEntityModel extends GeoModel<ArchibotEntity> {

    @Override
    public ResourceLocation getModelResource(ArchibotEntity archibotEntity) {
        return new ResourceLocation(PCUMod.MOD_ID, "geo/archibot.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ArchibotEntity archibotEntity) {
        return new ResourceLocation(PCUMod.MOD_ID, "textures/entity/archibot.png");

    }

    @Override
    public ResourceLocation getAnimationResource(ArchibotEntity archibotEntity) {
        return new ResourceLocation(PCUMod.MOD_ID, "animations/archibot.animation.json");

    }

    @Override
    public void setCustomAnimations(ArchibotEntity animatable, long instanceId, AnimationState<ArchibotEntity> animationState) {
        //
    }
}
