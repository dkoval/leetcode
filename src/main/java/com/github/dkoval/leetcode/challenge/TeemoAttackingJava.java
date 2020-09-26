package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

public class TeemoAttackingJava implements TeemoAttacking {

    @Override
    public int findPoisonedDuration(@NotNull int[] timeSeries, int duration) {
        int result = 0;
        int prevAttackEndTime = Integer.MIN_VALUE;
        for (int t : timeSeries) {
            int attackEndTime = t + duration - 1;
            result += (t <= prevAttackEndTime) ? attackEndTime - prevAttackEndTime : duration;
            prevAttackEndTime = attackEndTime;
        }
        return result;
    }
}
