package net.awaren.pcu_mod.entity.ai;

import net.awaren.pcu_mod.entity.custom.Archibot;
import net.awaren.pcu_mod.entity.custom.Archisentinel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

public class ArchisentinelRangedAttackGoal extends Goal {

    private final Archisentinel mob;
    private final double moveSpeedAmp;
    private int attackCooldown;
    private final int initialAttackCooldown;
    private final float maxAttackDistance;


    public ArchisentinelRangedAttackGoal(Archisentinel mob, double moveSpeedAmp, int attackCooldown, float maxAttackDistance) {
        this.mob = mob;
        this.moveSpeedAmp = moveSpeedAmp;
        this.attackCooldown = attackCooldown;
        this.maxAttackDistance = maxAttackDistance;

        this.initialAttackCooldown = attackCooldown;
    }

    @Override
    public void start() {
        super.start();
        mob.setAggressive(true);
        attackCooldown = 20;
    }

    @Override
    public void stop() {
        super.stop();
        mob.setAggressive(false);
    }

    @Override
    public boolean canUse() {
        LivingEntity target = mob.getTarget();

        return target != null && target.isAlive();
    }

    @Override
    public boolean canContinueToUse() {
        return this.canUse();
    }

    @Override
    public void tick() {
        LivingEntity target = mob.getTarget();
        if (target == null) return;

        mob.lookAt(target, 30f, 30f);

        double distanceToTarget = mob.distanceToSqr(target.getX(), target.getY(), target.getZ());

        if (distanceToTarget < (maxAttackDistance * maxAttackDistance)) {
            mob.getNavigation().stop();
            mob.getLookControl().setLookAt(target);
            attackCooldown--;

            if (attackCooldown <= 0) {
                mob.performRangedAttack(target, 0.1f);
                attackCooldown = initialAttackCooldown;
            }
        }

        else {
            mob.getNavigation().moveTo(target, moveSpeedAmp);
        }
    }
}
