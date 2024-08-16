package net.awaren.pcu_mod.datagen;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PCUMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BARRIUM_ORE);
        blockWithItem(ModBlocks.TERBIUM_ORE);
        blockWithItem(ModBlocks.MALACHITE_ORE);
        blockWithItem(ModBlocks.NEODYME_ORE);
        blockWithItem(ModBlocks.LUTECIUM_ORE);

        simpleBlockWithItem(ModBlocks.ENCLUME_ALLIAGE.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/enclume_alliage")));

        simpleBlockWithItem(ModBlocks.FUSIONNEUR.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/fusionneur")));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
