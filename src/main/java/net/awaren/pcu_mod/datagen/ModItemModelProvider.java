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
        for(RegistryObject<Item> item: ModItems.ITEMS.getEntries()) {
            simpleItem(item);
        }
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PCUMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
