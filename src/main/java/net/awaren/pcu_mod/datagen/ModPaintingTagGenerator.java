package net.awaren.pcu_mod.datagen;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.painting.ModPaintings;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModPaintingTagGenerator extends PaintingVariantTagsProvider {
    public ModPaintingTagGenerator(PackOutput p_255750_, CompletableFuture<HolderLookup.Provider> p_256184_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_255750_, p_256184_, PCUMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(PaintingVariantTags.PLACEABLE)
                .add(
                        ModPaintings.IDRIS.getKey(),
                        ModPaintings.JNOUNEX.getKey());
    }
}
