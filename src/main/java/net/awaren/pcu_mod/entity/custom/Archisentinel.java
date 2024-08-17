package net.awaren.pcu_mod.entity.custom;

import net.awaren.pcu_mod.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;

public class Archisentinel extends Monster implements GeoEntity {


    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);


    protected Archisentinel(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
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
        return ModSounds.ARCHISENTINEL_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.ARCHISENTINEL_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ARCHISENTINEL_DEATH.get();
    }

    @Override
    protected void playStepSound(BlockPos pPos, BlockState pState) {
        playSound(ModSounds.ARCHIBOT_STEP.get(), 0.3f, 1f);
    }

    // Anim shit

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
