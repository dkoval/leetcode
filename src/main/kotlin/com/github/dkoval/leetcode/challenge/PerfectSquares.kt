package com.github.dkoval.leetcode.challenge

/**
 * [Perfect Squares]https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3373/
 *
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 */
object PerfectSquares {

    fun numSquares(n: Int): Int {
        val dp = MutableList(n + 1) { 0 }
        for (x in 1..n) {
            var min = x // upper bound  n = 1 + 1 + ... + 1 (n times)
            var y = 1
            var square = 1
            while (square <= x) {
                min = minOf(min, 1 + dp[x - square])
                y++
                square = y * y
            }
            dp[x] = min
        }
        return dp[n]
    }
}