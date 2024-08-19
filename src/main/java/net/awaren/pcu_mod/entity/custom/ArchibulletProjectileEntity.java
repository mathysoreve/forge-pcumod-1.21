package net.awaren.pcu_mod.entity.custom;

import net.awaren.pcu_mod.entity.ModEntities;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
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

public class ArchibulletProjectileEntity extends AbstractHurtingProjectile implements GeoEntity {

    private int damage = 3;
    private static final float VELOCITY_MULTIPLIER = 1.5f;

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public ArchibulletProjectileEntity(EntityType<? extends AbstractHurtingProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ArchibulletProjectileEntity(Level pLevel) {
        super(ModEntities.ARCHIBULLET_PROJECTILE.get(), pLevel);
    }

    @Override
    public boolean isOnFire() {
        return false;
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        return false;
    }

    @Override
    protected boolean shouldBurn() {
        return false;
    }

    @Override
    public boolean isPickable() {
        return false;
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    public void tick() {
        super.tick();

        Vec3 motion = getDeltaMovement();
        setDeltaMovement(motion);

        this.move(MoverType.SELF, getDeltaMovement());

        if(tickCount > 100 || isInWaterOrBubble()) {
            discard();
        }

        // Particules de fumée
        if (this.level().isClientSide) {
            this.level().addParticle(ParticleTypes.SMOKE,
                    this.getX(), this.getY(), this.getZ(), motion.x * 0.2, motion.y * 0.2, motion.z * 0.2);
        }

    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide) {
            if (pResult instanceof EntityHitResult entityHitResult) {
                onHitEntity(entityHitResult);
            }
            this.discard();
        }

    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);

        if(!this.level().isClientSide) {
            if (pResult.getEntity() instanceof LivingEntity livingEntity) {

                System.out.println("Projectile hit : " + livingEntity.getName().getString());

                livingEntity.hurt(this.damageSources().mobProjectile(this, (LivingEntity) this.getOwner()), this.damage);

            }
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

    public double getVelocityMultiplier() {
        return VELOCITY_MULTIPLIER;
    }
}
