package com.github.dkoval.leetcode.challenge

object WordBreak2Rev1 : WordBreak2 {

    // Resource: https://www.youtube.com/watch?v=9-grHHGUVls
    override fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val dp = mutableMapOf<String, List<String>>()
        fun doWordBreak(s: String): List<String> {
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
                        val tmp = doWordBreak(s.substring(word.length))
                        for (elem in tmp) {
                            result.add("$word $elem")
                        }
                    }
                }
            }
            dp[s] = result
            return result
        }
        return doWordBreak(s)
    }
}