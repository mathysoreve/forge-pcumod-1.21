package net.awaren.pcu_mod.item.client;

import net.awaren.pcu_mod.item.custom.SombreroItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SombreroItemRenderer extends GeoArmorRenderer<SombreroItem> {
    public SombreroItemRenderer() {
        super(new SombreroItemModel());
    }
}
