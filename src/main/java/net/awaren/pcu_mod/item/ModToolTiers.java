package net.awaren.pcu_mod.item;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.utils.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier ELBALITE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 5000, 12f, 4f, 25,
                    ModTags.Blocks.NEED_ELBALITE_TOOL, () -> Ingredient.of(ModItems.ELBALITE.get())),
            new ResourceLocation(PCUMod.MOD_ID, "elbalite_ingot"), List.of(Tiers.NETHERITE), List.of());
}
