package net.awaren.pcu_mod.event;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.entity.ModEntities;
import net.awaren.pcu_mod.entity.custom.ArchibotEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PCUMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.ARCHIBOT.get(), ArchibotEntity.createAttributes().build());
        
    }
}
