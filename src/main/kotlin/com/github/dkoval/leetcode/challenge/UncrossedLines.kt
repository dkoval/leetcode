package com.github.dkoval.leetcode.challenge

import kotlin.math.max

/**
 * [Uncrossed Lines](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3340/)
 *
 * We write the integers of A and B (in the order they are given) on two separate horizontal lines.
 * Now, we may draw connecting lines: a straight line connecting two numbers ```A[i]``` and ```B[j]``` such that:
 * - ```A[i] == B[j]```;
 * - The line we draw does not intersect any other connecting (non-horizontal) line.
 *
 * Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
 * Return the maximum number of connecting lines we can draw in this way.
 */
object UncrossedLines {

    // Resource: https://www.youtube.com/watch?v=jLv-5coG-qQ
    fun maxUncrossedLines(A: IntArray, B: IntArray): Int {
        val m = A.size
        val n = B.size
        // dp[i][j] denotes the maximum number of uncrossed connecting lines between A[0:i] and B[0:j]
        val dp = Array(m + 1) { IntArray(n + 1) { 0 } }
        for (i in 1..m) {
            for (j in 1..n) {
                dp[i][j] =
                    if (A[i - 1] == B[j - 1]) 1 + dp[i - 1][j - 1]
                    else max(dp[i][j - 1], dp[i - 1][j])
            }
        }
        return dp[m][n] // the largest element in dp
    }
}