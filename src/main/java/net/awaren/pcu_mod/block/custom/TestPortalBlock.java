package net.awaren.pcu_mod.block.custom;

import net.awaren.pcu_mod.worldgen.dimension.ModDimensions;
import net.awaren.pcu_mod.worldgen.portal.ModTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class TestPortalBlock extends Block {

    public TestPortalBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(pPlayer.canChangeDimensions()) {
            handleTeleport(pPlayer, pPos);
            return InteractionResult.SUCCESS;
        }
        else {
            return InteractionResult.CONSUME;
        }
    }

    private void handleTeleport(Entity player, BlockPos blockPos) {
        if (player.level() instanceof ServerLevel serverLevel) {
            MinecraftServer minecraftServer = serverLevel.getServer();

            ResourceKey<Level> resourceKey =
                    player.level().dimension() == ModDimensions.DIGITAL_WORLD_LEVEL_KEY ? Level.OVERWORLD : ModDimensions.DIGITAL_WORLD_LEVEL_KEY;

            ServerLevel portalDimension = minecraftServer.getLevel(resourceKey);

                if(portalDimension != null && !player.isPassenger()) {

                    if(resourceKey == ModDimensions.DIGITAL_WORLD_LEVEL_KEY) {
                        player.changeDimension(portalDimension, new ModTeleporter(blockPos, true));
                    }
                    else {
                        player.changeDimension(portalDimension, new ModTeleporter(blockPos, false));

                    }
                }
            }
        }
    }
