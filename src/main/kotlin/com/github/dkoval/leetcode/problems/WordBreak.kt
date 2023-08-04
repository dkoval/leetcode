package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.challenge.WordBreak

// Time complexity: O(N^2), space complexity: O(N)
object WordBreakDPBottomUp : WordBreak {

    // Resources:
    // https://www.youtube.com/watch?v=1U4jQusbeJc
    // https://www.youtube.com/watch?v=iWenZCZEBIA&t=70s
    override fun wordBreak(s: String, wordDict: List<String>): Boolean {
        return doWordBreak(s, wordDict.toSet())
    }

    private fun doWordBreak(s: String, wordDict: Set<String>): Boolean {
        val dp = BooleanArray(s.length + 1) // whether s.substring(0, i) can be formed with `wordDict`
        dp[0] = true // an empty string can always be formed
        val dictWordMaxLength = dictWordMaxLength(wordDict)
        for (i in 1..s.length) {
            var j = i - 1
            while (j >= 0 && i - j <= dictWordMaxLength) {
                if (dp[j] && s.substring(j, i) in wordDict) {
                    dp[i] = true
                    break
                }
                j--
            }
        }
        return dp[dp.lastIndex]
    }

    private fun dictWordMaxLength(wordDict: Set<String>): Int {
        var maxLength = 0
        for (word in wordDict) {
            maxLength = maxOf(maxLength, word.length)
        }
        return maxLength
    }
}