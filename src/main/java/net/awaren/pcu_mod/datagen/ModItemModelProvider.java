package net.awaren.pcu_mod.datagen;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PCUMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.BARRIUM_INGOT);
        simpleItem(ModItems.RAW_TERBIUM);
        simpleItem(ModItems.MALACHITE);
        simpleItem(ModItems.NEODYME_INGOT);
        simpleItem(ModItems.YTTERBIUM_INGOT);
        simpleItem(ModItems.LUTECIUM_INGOT);
        simpleItem(ModItems.SCANDIUM_INGOT);
        simpleItem(ModItems.PYRITE_INGOT);
        simpleItem(ModItems.CAVALITE_INGOT);
        simpleItem(ModItems.PYREGRITE_INGOT);
        simpleItem(ModItems.PYGALITE_INGOT);
        simpleItem(ModItems.CAVARITE_INGOT);
        simpleItem(ModItems.CADINITE_INGOT);
        simpleItem(ModItems.NEGRIUM_SHARD);
        simpleItem(ModItems.REGALIUM_SHARD);
        simpleItem(ModItems.CONNERITE_SHARD);
        simpleItem(ModItems.DIVINITE_SHARD);
        simpleItem(ModItems.NEGRIUM);
        simpleItem(ModItems.REGALIUM);
        simpleItem(ModItems.CONNERITE);
        simpleItem(ModItems.DIVINITE);
        simpleItem(ModItems.AMADEUM);
        simpleItem(ModItems.ELBALITE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PCUMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
