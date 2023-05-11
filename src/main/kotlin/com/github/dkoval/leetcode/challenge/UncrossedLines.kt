package com.github.dkoval.leetcode.challenge

import kotlin.math.max

object UncrossedLinesDPBottomUp : UncrossedLines {

    // Resource: https://www.youtube.com/watch?v=jLv-5coG-qQ
    override fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
        val n1 = nums1.size
        val n2 = nums2.size

        // dp[i][j] denotes the maximum number of uncrossed connecting lines between A[0:i] and B[0:j]
        val dp = Array(n1 + 1) { IntArray(n2 + 1) { 0 } }
        for (i in 1..n1) {
            for (j in 1..n2) {
                dp[i][j] =
                    if (nums1[i - 1] == nums2[j - 1]) 1 + dp[i - 1][j - 1]
                    else max(dp[i][j - 1], dp[i - 1][j])
            }
        }
        return dp[n1][n2] // the largest element in dp
    }
}