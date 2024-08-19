package net.awaren.pcu_mod.item.custom;

import net.awaren.pcu_mod.entity.custom.ArchibulletProjectileEntity;
import net.awaren.pcu_mod.item.ModItems;
import net.awaren.pcu_mod.item.client.archigun.ArchigunItemRenderer;
import net.awaren.pcu_mod.item.client.sombrero.SombreroItemRenderer;
import net.awaren.pcu_mod.sound.ModSounds;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.RenderUtils;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class ArchigunItem extends ProjectileWeaponItem implements GeoItem {

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    private static final Predicate<ItemStack> ARCHIBULLETS = (stack) -> stack.is(ModItems.ARCHIBULLET.get());

    public ArchigunItem(Properties pProperties) {
        super(pProperties);
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


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private ArchigunItemRenderer renderer;


            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if(renderer == null) {
                    renderer = new ArchigunItemRenderer();
                }

                return renderer;
            }
        });
    }

    @Override
    public double getTick(Object itemStack) {
        return RenderUtils.getCurrentTick();
    }
}
