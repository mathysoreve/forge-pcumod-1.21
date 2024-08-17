package net.awaren.pcu_mod.entity.custom;

import net.awaren.pcu_mod.entity.ai.ArchibotRangedAttackGoal;
import net.awaren.pcu_mod.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class Archibot extends Monster implements GeoEntity, RangedAttackMob {

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public Archibot(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(2, new ArchibotRangedAttackGoal(this, 1.0D, 25, 15f));

        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.MOVEMENT_SPEED, 0.5)
                .add(Attributes.ATTACK_DAMAGE, 4)
                .add(Attributes.ARMOR_TOUGHNESS, 2)
                .add(Attributes.FOLLOW_RANGE, 30);
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return ModSounds.ARCHIBOT_AMBIENT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ARCHIBOT_DEATH.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {

        return ModSounds.ARCHIBOT_HURT.get();
    }

    @Override
    protected void playStepSound(BlockPos pPos, BlockState pState) {
        playSound(ModSounds.ARCHIBOT_STEP.get(), 0.20f, 1f);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, "controller", 0, this::predicate));
        controllerRegistrar.add(new AnimationController(this, "attackController", 0, this::attackPredicate));
    }



    // TODO : mettre les animations sinon ça va planter

    private PlayState predicate(AnimationState animationState) {
        if(animationState.isMoving()) {
            animationState.getController().setAnimation(RawAnimation.begin().then("animation.archibot.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        animationState.getController().setAnimation(RawAnimation.begin().then("animation.archibot.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationState animationState) {
        if(this.swinging && animationState.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            animationState.getController().forceAnimationReset();
            animationState.getController().setAnimation(RawAnimation.begin().then("animation.archibot.attack", Animation.LoopType.PLAY_ONCE));
            this.swinging = false;
        }

        return PlayState.CONTINUE;
    }



    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void performRangedAttack(LivingEntity target, float pVelocity) {

        System.out.println("Performing ranged attack!");

        ArchibulletProjectileEntity bullet = new ArchibulletProjectileEntity(this.level());

        Vec3 position = this.position();
        Vec3 targetPosition = target.position();
        Vec3 direction = targetPosition.subtract(position).normalize();

        bullet.setPos(position.x, position.y + 1, position.z);

        double velocityMultiplier = bullet.getVelocityMultiplier();
        bullet.setDeltaMovement(direction.scale(velocityMultiplier));

        this.level().addFreshEntity(bullet);

        playSound(ModSounds.GUN_FIRE.get());

        System.out.println("Bullet shot towards: " + direction.x + ", " + direction.y + ", " + direction.z);

    }
}
