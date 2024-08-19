package net.awaren.pcu_mod.worldgen.biome.surface;

import net.awaren.pcu_mod.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRules {

    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource BONE_BLOCK = makeStateRule(Blocks.BONE_BLOCK);
    private static final SurfaceRules.RuleSource SLIME_BLOCK = makeStateRule(Blocks.SLIME_BLOCK);

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return SurfaceRules.sequence(
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.DIGITAL_LANDS),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, BONE_BLOCK)),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SLIME_BLOCK)),

                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
        );

    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
