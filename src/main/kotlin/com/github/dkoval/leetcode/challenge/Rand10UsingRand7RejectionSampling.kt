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
interface Rand10UsingRand7 {

    fun rand10(): Int
}

object Rand10UsingRand7RejectionSampling : Rand10UsingRand7 {

    private fun rand7(): Int = Random.nextInt(1, 8)

    // Resource: https://leetcode.com/problems/implement-rand10-using-rand7/solution/
    override fun rand10(): Int {
        var idx: Int // idx is a 1-based index
        do {
            val row = rand7()
            val col = rand7()
            idx = (row - 1) * 7 + col
        } while (idx > 40)
        return (idx - 1) % 10 + 1
    }
}

object Rand10UsingRand7KnowledgeCenter : Rand10UsingRand7 {

    private fun rand7(): Int = Random.nextInt(1, 8)

    // Resource: https://www.youtube.com/watch?v=BvYd6KSW4nQ&t=383s
    override fun rand10(): Int {
        var v1: Int
        do {
            v1 = rand7()
        } while (v1 > 5) // ignore 6, 7
        var v2: Int
        do {
            v2 = rand7()
        } while (v2 == 7) // ignore 7
        // map v2's value [1..3] to [1..5], [4..6] to [6..10]
        return if (v2 < 4) v1 else v1 + 5
    }
}