package com.github.dkoval.leetcode.interview.array

/**
 * [Longest Palindromic Substring](https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/780/)
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */
interface LongestPalindromicSubstring {

    fun longestPalindrome(s: String): String
}

object LongestPalindromicSubstringBruteForce : LongestPalindromicSubstring {

    override fun longestPalindrome(s: String): String {
        var result = ""
        for (i in s.indices) {
            for (j in i until s.length) {
                val substr = s.substring(i..j)
                if (substr.isPalindrome() && substr.length > result.length) {
                    result = substr
                }
            }
        }
        return result
    }

    private fun String.isPalindrome(): Boolean {
        for (i in 0 until length / 2) {
            if (this[i] != this[length - i - 1]) return false
        }
        return true
    }
}