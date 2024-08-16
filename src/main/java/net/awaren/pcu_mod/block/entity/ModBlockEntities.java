package net.awaren.pcu_mod.block.entity;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static  final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PCUMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<EnclumeAlliageBlockEntity>> ENCLUME_ALLIAGE_BE =
            BLOCK_ENTITIES.register("enclume_alliage_be", () ->
                    BlockEntityType.Builder.of(EnclumeAlliageBlockEntity::new,
                            ModBlocks.ENCLUME_ALLIAGE.get()).build(null));

    public static final RegistryObject<BlockEntityType<FusionneurBlockEntity>> FUSIONNEUR_BE =
            BLOCK_ENTITIES.register("fusionneur_be", () ->
                    BlockEntityType.Builder.of(FusionneurBlockEntity::new,
                            ModBlocks.FUSIONNEUR.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
