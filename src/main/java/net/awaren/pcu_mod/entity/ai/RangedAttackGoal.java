package net.awaren.pcu_mod.entity.ai;

import net.awaren.pcu_mod.entity.custom.ArchibotEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

public class RangedAttackGoal extends Goal {

    private final ArchibotEntity mob;
    private final double moveSpeedAmp;
    private int attackCooldown;
    private int initialAttackCooldown;
    private final float maxAttackDistance;


    public RangedAttackGoal(ArchibotEntity mob, double moveSpeedAmp, int attackCooldown, float maxAttackDistance) {
        this.mob = mob;
        this.moveSpeedAmp = moveSpeedAmp;
        this.attackCooldown = attackCooldown;
        this.maxAttackDistance = maxAttackDistance;

        this.initialAttackCooldown = attackCooldown;
    }

    @Override
    public void start() {
        super.start();
        attackCooldown = 20;
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
