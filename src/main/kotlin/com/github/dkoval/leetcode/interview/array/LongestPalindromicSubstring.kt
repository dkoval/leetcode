package com.github.dkoval.leetcode.interview.array

/**
 * [Longest Palindromic Substring](https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/780/)
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */
interface LongestPalindromicSubstring {

    fun longestPalindrome(s: String): String
}

// Time complexity: O(N^3)
object LongestPalindromicSubstringBruteForce : LongestPalindromicSubstring {

    override fun longestPalindrome(s: String): String {
        var startIndex = 0
        var endIndex = 0
        var maxLength = 0
        for (i in s.indices) {
            for (j in i until s.length) {
                val length = j - i + 1
                if (length > maxLength && s.isPalindrome(i, j)) {
                    maxLength = length
                    startIndex = i
                    endIndex = j
                }
            }
        }
        return if (maxLength > 0) s.substring(startIndex..endIndex) else ""
    }

    private fun String.isPalindrome(startIndex: Int, endIndex: Int): Boolean {
        var i = startIndex
        var j = endIndex
        while (i < j) {
            if (this[i] != this[j]) return false
            i++
            j--
        }
        return true
    }
}