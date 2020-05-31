package com.github.dkoval.leetcode.challenge

import kotlin.math.min

/**
 * [Edit Distance](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3346/)
 *
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 * - Insert a character
 * - Delete a character
 * - Replace a character
 */
object EditDistance {

    // Resources:
    // https://www.youtube.com/watch?v=We3YDTzNXEk
    // https://www.gohired.in/2019/10/10/leetcode-edit-distance/
    fun minDistance(word1: String, word2: String): Int {
        // DP solution, where
        // dp[i][j] is the min number of operations to make
        // word1 upto length i and word2 upto length j equal
        val dp = Array(word1.length + 1) { IntArray(word2.length + 1) }
        // base cases
        for (i in 0..word1.length) {
            dp[i][0] = i
        }
        for (j in 0..word2.length) {
            dp[0][j] = j
        }
        // looping through all cases
        for (i in 1..word1.length) {
            for (j in 1..word2.length) {
                if (word1[i - 1] == word2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    dp[i][j] = 1 + min(min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1])
                }
            }
        }
        return dp[word1.length][word2.length]
    }
}