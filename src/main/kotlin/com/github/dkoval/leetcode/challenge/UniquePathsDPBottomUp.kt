package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.problems.UniquePaths

object UniquePathsDPBottomUp : UniquePaths {

    override fun uniquePaths(m: Int, n: Int): Int {
        // dp[i][j] - the number of possible unique paths that the robot can take to reach (i, j) from (0, 0)
        val dp = Array(m) { IntArray(n) { 0 } }
        for (i in 0 until m) {
            for (j in 0 until n) {
                // base case: either 1st row or 1st column
                if (i == 0 || j == 0) {
                    dp[i][j] = 1
                    continue
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            }
        }
        return dp[m - 1][n - 1]
    }
}