package net.awaren.pcu_mod.item.custom;

import net.awaren.pcu_mod.entity.custom.ArchibulletProjectileEntity;
import net.awaren.pcu_mod.item.ModItems;
import net.awaren.pcu_mod.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;

import java.util.function.Predicate;

public class ArchigunItem extends ProjectileWeaponItem {

    private static final Predicate<ItemStack> ARCHIBULLETS = (stack) -> stack.is(ModItems.ARCHIBULLET.get());

    private int bonusDamage;
    private int delay;

    public ArchigunItem(Properties pProperties, int bonusDamage, int delay) {
        super(pProperties);
        this.bonusDamage = bonusDamage;
        this.delay = delay;
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARCHIBULLETS;
    }

    @Override
    public int getDefaultProjectileRange() {
        return 8;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack gun = player.getItemInHand(hand);
        ItemStack ammo = player.getProjectile(gun);

        if(!world.isClientSide) {
            shoot(world, player);

            player.sendSystemMessage(Component.literal("Shooting!"));
        }

        return InteractionResultHolder.fail(gun);
    }

    public void shoot(Level world, Player player){
        ArchibulletProjectileEntity bullet = new ArchibulletProjectileEntity(world);

        bullet.setPos(player.position().x, player.position().y, player.position().z);

        world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.GUN_FIRE.get(), SoundSource.PLAYERS, 1f, 1f);

        world.addFreshEntity(bullet);
    }


}
