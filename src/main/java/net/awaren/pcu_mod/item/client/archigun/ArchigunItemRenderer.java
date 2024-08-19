package net.awaren.pcu_mod.item.client.archigun;

import net.awaren.pcu_mod.item.custom.ArchigunItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ArchigunItemRenderer extends GeoItemRenderer<ArchigunItem> {

    public ArchigunItemRenderer() {
        super(new ArchigunItemModel());
    }
}
