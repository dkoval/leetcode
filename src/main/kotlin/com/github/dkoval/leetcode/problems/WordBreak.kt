package com.github.dkoval.leetcode.problems

/**
 * [Word Break](https://leetcode.com/problems/word-break/)
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 * - The same word in the dictionary may be reused multiple times in the segmentation.
 * - You may assume the dictionary does not contain duplicate words.
 */
interface WordBreak {

    fun wordBreak(s: String, wordDict: List<String>): Boolean
}


// Time complexity: O(N^2), space complexity: O(N)
object WordBreakDPTopDown : WordBreak {

    override fun wordBreak(s: String, wordDict: List<String>): Boolean = doWordBreak(s, wordDict.toSet(), mutableMapOf())

    private fun doWordBreak(s: String, wordDict: Set<String>, memo: MutableMap<String, Boolean>): Boolean {
        if (s in wordDict) return true
        val alreadySolved = memo[s]
        if (alreadySolved != null) return alreadySolved
        for (i in 1..s.length) {
            if (s.substring(0, i) in wordDict && doWordBreak(s.substring(i), wordDict, memo)) {
                memo[s] = true
                return true
            }
        }
        memo[s] = false
        return false
    }
}

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