package net.awaren.pcu_mod.item;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.block.ModBlocks;
import net.awaren.pcu_mod.painting.ModPaintings;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PCUMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PCU_BLOCKS_TAB = CREATIVE_MODE_TABS.register("pcu_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.BARRIUM_ORE.get()))

                    .title(Component.translatable("creativetab.pcu_blocks_tab"))

                    .displayItems((pParameters, pOutput) -> {

                        ModBlocks.BLOCKS.getEntries()
                                .forEach(block -> pOutput.accept(block.get()));

                    }).build());

    public static final RegistryObject<CreativeModeTab> PCU_ITEMS_TAB = CREATIVE_MODE_TABS.register("pcu_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.ELBALITE.get()))

                    .title(Component.translatable("creativetab.pcu_items_tab"))

                    .displayItems((pParameters, pOutput) -> {

                        ModItems.ITEMS.getEntries().stream()
                                .filter(item -> !(item.get() instanceof BlockItem) || !(item.get() instanceof ForgeSpawnEggItem))
                                .forEach(item -> pOutput.accept(item.get()));

                    })

                    .build());

    public static final RegistryObject<CreativeModeTab> PCU_MOBS_TAB = CREATIVE_MODE_TABS.register("pcu_mobs_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.ARCHIBOT_SPAWN_EGG.get()))

                    .title(Component.translatable("creativetab.pcu_mobs_tab"))

                    .displayItems((pParameters, pOutput) -> {
                        ModItems.ITEMS.getEntries().stream()
                                .filter(item -> (item.get() instanceof ForgeSpawnEggItem))
                                .forEach(item -> pOutput.accept(item.get()));
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
