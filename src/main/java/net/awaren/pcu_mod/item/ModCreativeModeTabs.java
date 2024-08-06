package net.awaren.pcu_mod.item;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PCUMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PCU_TAB = CREATIVE_MODE_TABS.register("pcu_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.BARRIUM_INGOT.get()))
                    .title(Component.translatable("creativetab.pcu_tab"))

                    .displayItems((pParameters, pOutput) -> {
                        for (RegistryObject<Block> block: ModBlocks.BLOCKS.getEntries()) {
                            pOutput.accept(block.get());
                        }

                        for (RegistryObject<Item> item: ModItems.ITEMS.getEntries()) {
                            pOutput.accept(item.get());
                        }


                    })

                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
