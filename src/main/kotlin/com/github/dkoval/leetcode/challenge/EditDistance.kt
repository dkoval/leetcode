package com.github.dkoval.leetcode.challenge

/**
 * [Edit Distance](https://leetcode.com/problems/edit-distance/)
 *
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 * - Insert a character
 * - Delete a character
 * - Replace a character
 *
 * Constraints:
 *
 * - 0 <= word1.length, word2.length <= 500
 * - word1 and word2 consist of lowercase English letters.
 */
interface EditDistance {

    fun minDistance(word1: String, word2: String): Int
}

// O(N1 * N2) time | O(N1 * N2) space
object EditDistanceDPBottomUp : EditDistance {

    // Resources:
    // https://www.youtube.com/watch?v=We3YDTzNXEk
    // https://www.gohired.in/2019/10/10/leetcode-edit-distance/
    override fun minDistance(word1: String, word2: String): Int {
        val n1 = word1.length
        val n2 = word2.length

        // dp[i][j] is the min number of operations required to convert word1[0 : i - 1] to word2[0 : j - 1]
        val dp = Array(n1 + 1) { IntArray(n2 + 1) }

        // base case #1: min operations required to convert word1 -> word2 == ""
        for (i in 1..n1) {
            dp[i][0] = i
        }

        // base case #2: min operations required to convert word1 == "" -> word2
        for (j in 1..n2) {
            dp[0][j] = j
        }

        // looping through all cases
        for (i in 1..n1) {
            for (j in 1..n2) {
                if (word1[i - 1] == word2[j - 1]) {
                    // nothing to do
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    // Options:
                    // #1: replace word1[i] with word2[j], then convert word1[0 : i - 1] to word2[0 : j]
                    // #2: remove word1[i], then convert word1[0 : i - 1] to word2[0 : j]
                    // #3: insert word[j] at the end of word1[0 : i], then convert word1[0 : i] to word2[0 : j - 1]
                    dp[i][j] = 1 + minOf(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1])
                }
            }
        }
        return dp[n1][n2]
    }
}