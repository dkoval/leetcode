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

// Time complexity: O(N^2)
object LongestPalindromicSubstringUsingExpandOutApproach : LongestPalindromicSubstring {

    // Resource: https://www.youtube.com/watch?v=y2BD4MJqV20&list=TLPQMjQwOTIwMjCNKBD_ObHf6w&index=2
    override fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return ""
        var startIndex = 0
        var endIndex = 0
        for (i in s.indices) {
            // 2 cases to handle:
            // - palindrome of odd length, like "racecar", where the middle element 'e' doesn't have a match
            // - regular palindrome of even length, like "abba", where each character has a match
            val length1 = lengthOfPalindromeExpandingFromMiddle(s, i, i)
            val length2 = lengthOfPalindromeExpandingFromMiddle(s, i, i + 1)
            val length = maxOf(length1, length2)
            if (length > endIndex - startIndex + 1) {
                startIndex = i - (length - 1) / 2
                endIndex = i + length / 2
            }
        }
        return s.substring(startIndex..endIndex)
    }

    private fun lengthOfPalindromeExpandingFromMiddle(s: String, startIndex: Int, endIndex: Int): Int {
        if (startIndex > endIndex) return 0
        var i = startIndex
        var j = endIndex
        while (i >= 0 && j < s.length && s[i] == s[j]) {
            i--
            j++
        }
        // after loop is executed: ...i, start, ..., end, j, ...
        // therefore length of s.substring(start..end) = end - start + 1 = end - i = j - 1 - i
        return j - i - 1
    }
}