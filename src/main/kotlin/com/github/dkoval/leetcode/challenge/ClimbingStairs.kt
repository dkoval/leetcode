package com.github.dkoval.leetcode.challenge

/**
 * [Climbing Stairs](https://leetcode.com/explore/featured/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3407/)
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Constraints:
 * - 1 <= n <= 45
 */
interface ClimbingStairs {

    fun climbStairs(n: Int): Int
}

object MemoClimbingStairs: ClimbingStairs {

    override fun climbStairs(n: Int): Int {
        val memo = IntArray(n + 1) { Int.MIN_VALUE }
        return doClimbStairs(n, memo)
    }

    private fun doClimbStairs(n: Int, memo: IntArray): Int = when {
        n < 0 -> 0
        n == 0 -> 1
        memo[n] != Int.MIN_VALUE -> memo[n]
        else -> {
            memo[n] = doClimbStairs(n - 1, memo) + doClimbStairs(n - 2, memo)
            memo[n]
        }
    }
}

object NoExtraSpaceClimbingStairs: ClimbingStairs {

    override fun climbStairs(n: Int): Int {
        if (n <= 2) return n
        var prevStep2 = 1
        var prevStep1 = 2
        for (i in 3..n) {
            val tmp = prevStep1
            prevStep1 += prevStep2
            prevStep2 = tmp
        }
        return prevStep1
    }
}