package net.awaren.pcu_mod.entity.client;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.entity.custom.Archisentinel;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class ArchisentinelEntityModel extends GeoModel<Archisentinel> {
    @Override
    public ResourceLocation getModelResource(Archisentinel archisentinel) {
        return new ResourceLocation(PCUMod.MOD_ID, "geo/archisentinel.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Archisentinel archisentinel) {
        return new ResourceLocation(PCUMod.MOD_ID, "textures/entity/archisentinel.png");

    }

    @Override
    public ResourceLocation getAnimationResource(Archisentinel archisentinel) {
        return new ResourceLocation(PCUMod.MOD_ID, "animations/animations.archisentinel.json");

    }

    @Override
    public void setCustomAnimations(Archisentinel animatable, long instanceId, AnimationState<Archisentinel> animationState) {
        //
    }
}
