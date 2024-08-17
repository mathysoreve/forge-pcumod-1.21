package net.awaren.pcu_mod.entity.client;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.entity.custom.Archibot;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ArchibotEntityRenderer extends GeoEntityRenderer<Archibot> {

    public ArchibotEntityRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ArchibotEntityModel());
    }

    @Override
    public ResourceLocation getTextureLocation(Archibot animatable) {
        return new ResourceLocation(PCUMod.MOD_ID, "textures/entity/archibot.png");
    }

}
