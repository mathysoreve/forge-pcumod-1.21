package net.awaren.pcu_mod.entity.custom;

import net.awaren.pcu_mod.entity.ModEntities;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;

public class ArchibulletProjectileEntity extends Projectile implements GeoEntity {

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public ArchibulletProjectileEntity(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    protected ArchibulletProjectileEntity(Level pLevel) {
        super(ModEntities.ARCHIBULLET_PROJECTILE.get(), pLevel);
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    public void tick() {
        super.tick();

        //
        if(!isNoGravity()) {
            setDeltaMovement(getDeltaMovement().add(0d, -0.05d, 0.5d));
        }

        this.move(MoverType.SELF, getDeltaMovement());

        if(isInWaterOrBubble()) {
            discard();
        }

        // Particules de fumée

        if (this.level().isClientSide) {
            Vec3 motion = this.getDeltaMovement();
            this.level().addParticle(ParticleTypes.SMOKE,
                    this.getX(), this.getY(), this.getZ(), motion.x * 0.2, motion.y * 0.2, motion.z * 0.2);
        }

    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);

        if (pResult.getType() == HitResult.Type.BLOCK) {
            discard();
        }

    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);

        Entity entity = pResult.getEntity();

        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.hurt(this.damageSources().thrown(this, this.getOwner()), 3f);

            setDeltaMovement(Vec3.ZERO);

            playSound(SoundEvents.ANVIL_HIT);

            discard();
        }

    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

}
