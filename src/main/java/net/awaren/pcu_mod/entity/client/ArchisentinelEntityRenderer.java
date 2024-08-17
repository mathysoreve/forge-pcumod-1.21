package net.awaren.pcu_mod.entity.client;

import net.awaren.pcu_mod.entity.custom.Archisentinel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ArchisentinelEntityRenderer extends GeoEntityRenderer<Archisentinel> {

    public ArchisentinelEntityRenderer(EntityRendererProvider.Context renderManager, GeoModel<Archisentinel> model) {
        super(renderManager, new ArchisentinelEntityModel());
    }
}
