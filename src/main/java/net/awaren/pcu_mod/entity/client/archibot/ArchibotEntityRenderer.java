package net.awaren.pcu_mod.entity.client.archibot;

import net.awaren.pcu_mod.entity.custom.Archibot;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ArchibotEntityRenderer extends GeoEntityRenderer<Archibot> {

    public ArchibotEntityRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ArchibotEntityModel());
    }

}
