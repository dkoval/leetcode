package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.problems.UniquePaths

/**
 * [Unique Paths](https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/543/week-5-june-29th-june-30th/3375/)
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * [Above is a 7 x 3 grid. How many possible unique paths are there?](https://assets.leetcode.com/uploads/2018/10/22/robot_maze.png)
 */
object UniquePathsDPBottomUp : UniquePaths {

    override fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m) { IntArray(n) { 0 } }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (i == 0 || j == 0) {
                    // either 1st row or 1st column
                    dp[i][j] = 1
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                }
            }
        }
        return dp[m - 1][n - 1]
    }
}