package net.awaren.pcu_mod.block;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.block.custom.EnclumeAlliage;
import net.awaren.pcu_mod.block.custom.Fusionneur;
import net.awaren.pcu_mod.block.custom.TestPortalBlock;
import net.awaren.pcu_mod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PCUMod.MOD_ID);

    //Liste des blocks
    public static final RegistryObject<Block> BARRIUM_ORE = registerBlock("barrium_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> TERBIUM_ORE = registerBlock("terbium_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> MALACHITE_ORE = registerBlock("malachite_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> NEODYME_ORE = registerBlock("neodyme_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> LUTECIUM_ORE = registerBlock("lutecium_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    //Liste de blocks entities
    public static final RegistryObject<Block> ENCLUME_ALLIAGE = registerBlock("enclume_alliage",
            () -> new EnclumeAlliage(BlockBehaviour.Properties.copy(Blocks.ANVIL).noOcclusion()));

    public static final RegistryObject<Block> FUSIONNEUR = registerBlock("fusionneur",
            () -> new Fusionneur(BlockBehaviour.Properties.copy(Blocks.ANVIL).noOcclusion()));

    public static final RegistryObject<Block> TEST_PORTAL_BLOCK = registerBlock("test_portal_block",
            () -> new TestPortalBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noLootTable().noOcclusion().noCollission()));











    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
