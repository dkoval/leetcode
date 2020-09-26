package com.github.dkoval.leetcode.challenge

/**
 * [Teemo Attacking](https://leetcode.com/explore/featured/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3473/)
 *
 * In LOL world, there is a hero called Teemo and his attacking can make his enemy Ashe be in poisoned condition.
 * Now, given the Teemo's attacking ascending time series towards Ashe and the poisoning time duration per Teemo's
 * attacking, you need to output the total time that Ashe is in poisoned condition.
 *
 * You may assume that Teemo attacks at the very beginning of a specific time point,
 * and makes Ashe be in poisoned condition immediately.
 */
interface TeemoAttacking {

    fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int
}

object TeemoAttackingKt : TeemoAttacking {

    override fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
        var result = 0
        var prevAttackEndTime = Int.MIN_VALUE
        for (t in timeSeries) {
            val attackEndTime = t + duration - 1
            result += if (t <= prevAttackEndTime) attackEndTime - prevAttackEndTime else duration
            prevAttackEndTime = attackEndTime
        }
        return result
    }
}