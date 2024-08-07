package net.awaren.pcu_mod.worldgen;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_BARRIUM_ORE_KEY = registerKey("barrium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_TERBIUM_ORE_KEY = registerKey("terbium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_MALACHITE_ORE_KEY = registerKey("malachite_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepSlateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        // A voir si on a besoin de ceux là un jour

        RuleTest netherrackReplaceable = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceable = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldBarriumOres = List.of(
                OreConfiguration.target(stoneReplaceable, ModBlocks.BARRIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepSlateReplaceable, ModBlocks.BARRIUM_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldTerbiumOres = List.of(
                OreConfiguration.target(stoneReplaceable, ModBlocks.TERBIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepSlateReplaceable, ModBlocks.TERBIUM_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldMalachiteOres = List.of(
                OreConfiguration.target(stoneReplaceable, ModBlocks.MALACHITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepSlateReplaceable, ModBlocks.MALACHITE_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_BARRIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldBarriumOres, 9));
        register(context, OVERWORLD_TERBIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTerbiumOres, 6));
        register(context, OVERWORLD_MALACHITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldMalachiteOres, 6));




    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(PCUMod.MOD_ID, name));
    }

    // J'ai rien compris à ce que j'ai écris -E
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
