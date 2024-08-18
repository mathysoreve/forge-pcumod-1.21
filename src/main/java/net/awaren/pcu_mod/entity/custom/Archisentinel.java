package net.awaren.pcu_mod.entity.custom;

import net.awaren.pcu_mod.entity.ai.ArchisentinelRangedAttackGoal;
import net.awaren.pcu_mod.item.ModItems;
import net.awaren.pcu_mod.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;

public class Archisentinel extends Monster implements GeoEntity, RangedAttackMob {

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);


    public Archisentinel(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Villager.class, true));

        this.goalSelector.addGoal(2, new ArchisentinelRangedAttackGoal(this, 1, 20, 20f));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));

    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, 4)
                .add(Attributes.ARMOR, 5)
                .add(Attributes.FOLLOW_RANGE, 30);
    }


    @Override
    public void performRangedAttack(LivingEntity target, float velocity) {

        System.out.println("Performing ranged attack!");

        Vec3 position = this.position();
        Vec3 targetPosition = target.position();
        Vec3 direction = targetPosition.subtract(position).normalize();


        ArchibulletProjectileEntity bullet = new ArchibulletProjectileEntity(this.level());
        bullet.setPos(position.x, position.y + 1, position.z);

        double velocityMultiplier = bullet.getVelocityMultiplier();
        bullet.setDeltaMovement(direction.scale(velocityMultiplier));

        bullet.shoot(bullet.getDeltaMovement().x, bullet.getDeltaMovement().y, bullet.getDeltaMovement().z, (float)velocityMultiplier, 2f);

        this.level().addFreshEntity(bullet);

        playSound(ModSounds.GUN_FIRE.get());

        String message = "Bullet shot towards: " + direction.x + ", " + direction.y + ", " + direction.z;

        System.out.println(message);



    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.ARCHIGUN.get()));
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
        playSound(ModSounds.ARCHISENTINEL_STEP.get(), 0.3f, 1f);
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
