package net.awaren.pcu_mod.datagen;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, PCUMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.MUSIC_DISCS)
                .add(
                        ModItems.PCU_THEME_DISC.get(),
                        ModItems.EL_MARIACHI_DISC.get(),
                        ModItems.LCP_THEME_DISC.get(),
                        ModItems.BLOOD_FLAVOURED_ROMANCE_DISC.get(),
                        ModItems.LOVE_AT_LAST_SIGHT_DISC.get(),
                        ModItems.NOT_GUILTY_DISC.get(),
                        ModItems.REGEDIT_DISC.get(),
                        ModItems.PCU_THEME_PERSO_DISC.get()
                );



    }
}
