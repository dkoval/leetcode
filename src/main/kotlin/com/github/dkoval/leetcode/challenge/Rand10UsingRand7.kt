package com.github.dkoval.leetcode.challenge

import kotlin.random.Random

/**
 * [Implement Rand10() Using Rand7()](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3439/)
 *
 * Given a function `rand7` which generates a uniform random integer in the range 1 to 7,
 * write a function `rand10` which generates a uniform random integer in the range 1 to 10.
 *
 * Do NOT use system's Math.random().
 */
object Rand10UsingRand7 {

    private fun rand7(): Int = Random.nextInt(1, 8)

    // Resource: https://leetcode.com/problems/implement-rand10-using-rand7/solution/
    fun rand10(): Int {
        var idx: Int // idx is a 1-based index
        do {
            val row = rand7()
            val col = rand7()
            idx = (row - 1) * 7 + col
        } while (idx > 40)
        return (idx - 1) % 10 + 1
    }
}