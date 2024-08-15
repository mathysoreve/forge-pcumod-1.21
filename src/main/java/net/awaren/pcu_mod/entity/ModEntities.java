package net.awaren.pcu_mod.entity;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.entity.custom.ArchibotEntity;
import net.awaren.pcu_mod.entity.custom.ArchibulletProjectileEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PCUMod.MOD_ID);

    public static final RegistryObject<EntityType<ArchibotEntity>> ARCHIBOT
            = ENTITY_TYPES.register("archibot",
            () -> EntityType.Builder.of(ArchibotEntity::new, MobCategory.MONSTER)
                    .sized(1f, 1.5f)
                    .build("archibot"));

    public static final RegistryObject<EntityType<ArchibulletProjectileEntity>> ARCHIBULLET_PROJECTILE
            = ENTITY_TYPES.register("archibullet_projectile",
            () -> EntityType.Builder.of(ArchibulletProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .build("archibullet_projectile"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
