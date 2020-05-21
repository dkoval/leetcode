package com.github.dkoval.leetcode.challenge

import kotlin.math.min

/**
 * [Count Square Submatrices with All Ones](https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3336/)
 *
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 */
object CountSquareSubmatricesWithAllOnes {

    // Resources:
    // https://www.youtube.com/watch?v=ojz8xZc8pog
    // https://www.youtube.com/watch?v=FO7VXDfS8Gk
    fun countSquares(matrix: Array<IntArray>): Int {
        val n = matrix.size
        val m = matrix[0].size
        val dp = Array(n + 1) { IntArray(m + 1) }
        var count = 0
        for (i in 1..n) {
            for (j in 1..m) {
                if (matrix[i - 1][j - 1] == 1) {
                    // take min of (previous column, previous row, previous diagonal) + 1
                    dp[i][j] = min(min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1
                    count += dp[i][j]
                }
            }
        }
        return count
    }
}