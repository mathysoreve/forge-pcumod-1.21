package net.awaren.pcu_mod.entity.client;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.entity.custom.Archibot;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class ArchibotEntityModel extends GeoModel<Archibot> {

    @Override
    public ResourceLocation getModelResource(Archibot archibot) {
        return new ResourceLocation(PCUMod.MOD_ID, "geo/archibot.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Archibot archibot) {
        return new ResourceLocation(PCUMod.MOD_ID, "textures/entity/archibot.png");

    }

    @Override
    public ResourceLocation getAnimationResource(Archibot archibot) {
        return new ResourceLocation(PCUMod.MOD_ID, "animations/archibot.animation.json");

    }

    @Override
    public void setCustomAnimations(Archibot animatable, long instanceId, AnimationState<Archibot> animationState) {
        //
    }
}
