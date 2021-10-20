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

        // Let f'(x, y) is number of structurally unique BSTs with x nodes in the left and y nodes in the right subtrees respectively,
        // then the total number of structurally unique BSTs with n nodes is
        // f(n) = f'(0, n - 1) + f'(1, n - 2) + ... + f'(0, n - 1), where
        // f'(k, n - k - 1) = f(k) * f(n - k - 1)

        // dp[i] is the number of structurally unique BSTs with i nodes, i.e. f(i)
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