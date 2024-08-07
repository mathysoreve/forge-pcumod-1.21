package net.awaren.pcu_mod.datagen.loot;

import net.awaren.pcu_mod.block.ModBlocks;
import net.awaren.pcu_mod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        this.add(ModBlocks.BARRIUM_ORE.get(), block ->
            createOreDrop(ModBlocks.BARRIUM_ORE.get(), ModItems.BARRIUM_INGOT.get())
        );

        this.add(ModBlocks.TERBIUM_ORE.get(), block ->
                createOreDrop(ModBlocks.TERBIUM_ORE.get(), ModItems.RAW_TERBIUM.get())
        );

        this.add(ModBlocks.MALACHITE_ORE.get(), block ->
                createMultipleOreDrops(ModBlocks.MALACHITE_ORE.get(), ModItems.MALACHITE.get(), 2.0F, 5.0f)
        );
    }

    protected LootTable.Builder createMultipleOreDrops(Block block, Item item, float minAmount, float maxAmount) {
        return createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minAmount, maxAmount)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
