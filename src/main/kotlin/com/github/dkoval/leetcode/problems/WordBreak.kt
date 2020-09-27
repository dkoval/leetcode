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

object WordBreakDPTopDown : WordBreak {

    override fun wordBreak(s: String, wordDict: List<String>): Boolean = doWordBreak(s, wordDict, mutableMapOf())

    private fun doWordBreak(s: String, wordDict: List<String>, memo: MutableMap<String, Boolean>): Boolean {
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