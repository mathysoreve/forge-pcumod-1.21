package net.awaren.pcu_mod.datagen;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
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
        simpleItem(ModItems.LUTECIUM_INGOT);
        simpleItem(ModItems.PYRITE_INGOT);
        simpleItem(ModItems.CAVALITE_INGOT);
        simpleItem(ModItems.NEGRIUM_SHARD);
        simpleItem(ModItems.DIVINITE_SHARD);
        simpleItem(ModItems.NEGRIUM);
        simpleItem(ModItems.DIVINITE);
        simpleItem(ModItems.AMADEUM);
        simpleItem(ModItems.ELBALITE);

        simpleItem(ModItems.SOMBRERO);

        simpleItem(ModItems.PCU_THEME_DISC);
        simpleItem(ModItems.EL_MARIACHI_DISC);
        simpleItem(ModItems.LCP_THEME_DISC);
        simpleItem(ModItems.BLOOD_FLAVOURED_ROMANCE_DISC);
        simpleItem(ModItems.LOVE_AT_LAST_SIGHT_DISC);
        simpleItem(ModItems.NOT_GUILTY_DISC);
        simpleItem(ModItems.REGEDIT_DISC);
        simpleItem(ModItems.PCU_THEME_PERSO_DISC);

        simpleItem(ModItems.ARCHIBULLET);

        withExistingParent(ModItems.ARCHIBOT_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PCUMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(PCUMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PCUMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}