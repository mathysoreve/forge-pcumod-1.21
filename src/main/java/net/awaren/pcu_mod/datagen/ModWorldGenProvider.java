package net.awaren.pcu_mod.datagen;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.worldgen.ModBiomeModifiers;
import net.awaren.pcu_mod.worldgen.ModConfiguredFeatures;
import net.awaren.pcu_mod.worldgen.ModPlacedFeatures;
import net.awaren.pcu_mod.worldgen.biome.ModBiomes;
import net.awaren.pcu_mod.worldgen.dimension.ModDimensions;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, ModDimensions::bootstrapType)

            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)

            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)

            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)

            .add(Registries.LEVEL_STEM, ModDimensions::bootstrapStem)

            .add(Registries.BIOME, ModBiomes::bootstrap);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(PCUMod.MOD_ID));
    }
}
