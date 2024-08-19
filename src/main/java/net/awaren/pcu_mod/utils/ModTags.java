package net.awaren.pcu_mod.utils;

import net.awaren.pcu_mod.PCUMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> NEED_ELBALITE_TOOL = tag("need_elbalite_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(PCUMod.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(PCUMod.MOD_ID, name));
        }

    }
}
