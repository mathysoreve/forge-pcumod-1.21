package net.awaren.pcu_mod.item.client;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.item.custom.SombreroItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SombreroItemModel extends GeoModel<SombreroItem> {

    @Override
    public ResourceLocation getModelResource(SombreroItem sombreroItem) {
        return new ResourceLocation(PCUMod.MOD_ID, "geo/sombrero.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SombreroItem sombreroItem) {
        return new ResourceLocation(PCUMod.MOD_ID, "textures/armor/sombrero.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SombreroItem sombreroItem) {
        return new ResourceLocation(PCUMod.MOD_ID, "animations/sombrero.animation.json");
    }
}
