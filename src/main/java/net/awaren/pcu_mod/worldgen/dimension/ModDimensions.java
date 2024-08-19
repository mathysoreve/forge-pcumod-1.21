package net.awaren.pcu_mod.worldgen.dimension;

import it.unimi.dsi.fastutil.Pair;
import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.worldgen.biome.ModBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

import java.util.List;
import java.util.OptionalLong;

public class ModDimensions {

    // DIGITAL WORLD
    public static final ResourceKey<LevelStem> DIGITAL_WORLD_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            new ResourceLocation(PCUMod.MOD_ID, "digital_world"));

    public static final ResourceKey<Level> DIGITAL_WORLD_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(PCUMod.MOD_ID, "digital_world"));

    public static final ResourceKey<DimensionType> DIGITAL_WORLD_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            new ResourceLocation(PCUMod.MOD_ID, "digital_world_type"));

    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(DIGITAL_WORLD_TYPE, new DimensionType(
                OptionalLong.of(6000),
                false,
                true,
                false,
                false,
                1.0,
                true,
                false,
                0,
                256,
                128,
                BlockTags.INFINIBURN_OVERWORLD,
                BuiltinDimensionTypes.OVERWORLD_EFFECTS,
                0.0f,
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)
        ));
    }

    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimensionTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
                new FixedBiomeSource(biomeRegistry.getOrThrow(ModBiomes.DIGITAL_LANDS)),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD));

// Si jamais on veut une dimension avec plusieurs biomes... -E
/*
        NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(Pair.of(
                                        Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.ERODED_BADLANDS)),
                                Pair.of(
                                        Climate.parameters(0.1F, 0.2F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.BIRCH_FOREST)),
                                Pair.of(
                                        Climate.parameters(0.3F, 0.6F, 0.1F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.OCEAN)),
                                Pair.of(
                                        Climate.parameters(0.4F, 0.3F, 0.2F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.DARK_FOREST))

                        ))),

                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.AMPLIFIED));
*/

        LevelStem stem = new LevelStem(dimensionTypes.getOrThrow(ModDimensions.DIGITAL_WORLD_TYPE), wrappedChunkGenerator);

        context.register(DIGITAL_WORLD_KEY, stem);
    }

}
