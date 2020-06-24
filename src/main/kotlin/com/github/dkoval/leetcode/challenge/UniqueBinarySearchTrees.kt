package com.github.dkoval.leetcode.challenge

/**
 * [Unique Binary Search Trees](https://leetcode.com/explore/featured/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3370/)
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 */
object UniqueBinarySearchTrees {

    // Resource: https://www.youtube.com/watch?v=4s7r3bO0hoU
    fun numTrees(n: Int): Int {
        if (n < 2) {
            return 1
        }
        val dp = IntArray(n + 1)
        dp[0] = 1
        dp[1] = 1
        for (i in 2..n) {
            for (k in 0 until i) {
                dp[i] += dp[k] * dp[i - k - 1]
            }
        }
        return dp.last()
    }
}