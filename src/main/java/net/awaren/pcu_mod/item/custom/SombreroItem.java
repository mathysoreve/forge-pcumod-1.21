package net.awaren.pcu_mod.item.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeItem;

import java.util.List;

public class SombreroItem extends ArmorItem implements IForgeItem {

    // TODO :
    //  - afficher le modèle 3D SUR LA TETE -E

    public SombreroItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    // Comportement des squelettes -E

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (!level.isClientSide() && player.getItemBySlot(EquipmentSlot.HEAD) == stack) {

            level.getEntitiesOfClass(Skeleton.class, player.getBoundingBox().inflate(15))
                    .forEach(skeleton -> {

                        skeleton.getNavigation().stop();
                        skeleton.setAggressive(false);
                        skeleton.setTarget(null);

                    });
        }
    }

}
