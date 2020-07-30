package com.github.dkoval.leetcode.challenge

/**
 * [Word Break II](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3406/)
 *
 * Given a non-empty string `s` and a dictionary `wordDict` containing a list of non-empty words,
 * add spaces in `s` to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 *
 * Note:
 * - The same word in the dictionary may be reused multiple times in the segmentation.
 * - You may assume the dictionary does not contain duplicate words.
 */
object WordBreak2 {

    // Resource: https://www.youtube.com/watch?v=9-grHHGUVls
    fun wordBreak(s: String, wordDict: List<String>): List<String> = doWordBreak(s, wordDict, mutableMapOf())

    private fun doWordBreak(s: String, wordDict: List<String>, dp: MutableMap<String, List<String>>): List<String> {
        val cachedResult = dp[s]
        if (cachedResult != null) {
            return cachedResult
        }
        val result = mutableListOf<String>()
        for (word in wordDict) {
            if (s.startsWith(word)) {
                if (word.length == s.length) {
                    result.add(word)
                } else {
                    val tmp = doWordBreak(s.substring(word.length), wordDict, dp)
                    for (elem in tmp) {
                        result.add("$word $elem")
                    }
                }
            }
        }
        dp[s] = result
        return result
    }
}