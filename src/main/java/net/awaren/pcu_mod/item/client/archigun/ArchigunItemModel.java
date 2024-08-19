package net.awaren.pcu_mod.item.client.archigun;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.item.custom.ArchigunItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import software.bernie.geckolib.model.GeoModel;

public class ArchigunItemModel extends GeoModel<ArchigunItem> {


    @Override
    public ResourceLocation getModelResource(ArchigunItem archigunItem) {
        return new ResourceLocation(PCUMod.MOD_ID, "geo/archigun.geo.json");

    }

    @Override
    public ResourceLocation getTextureResource(ArchigunItem archigunItem) {
        return new ResourceLocation(PCUMod.MOD_ID, "textures/models/item/archigun.png");

    }

    @Override
    public ResourceLocation getAnimationResource(ArchigunItem archigunItem) {
        return new ResourceLocation(PCUMod.MOD_ID, "animations/archigun.animation.json");

    }
}
