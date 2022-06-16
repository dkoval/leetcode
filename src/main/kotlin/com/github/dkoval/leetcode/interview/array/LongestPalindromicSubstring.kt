package com.github.dkoval.leetcode.interview.array

import com.github.dkoval.leetcode.challenge.LongestPalindromicSubstring

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
        return s.substring(startIndex..endIndex)
    }

    private fun String.isPalindrome(startIndex: Int, endIndex: Int): Boolean {
        var l = startIndex
        var r = endIndex
        while (l < r) {
            if (this[l] != this[r]) return false
            l++
            r--
        }
        return true
    }
}

// Time complexity: O(N^2)
object LongestPalindromicSubstringExpandAroundCenter : LongestPalindromicSubstring {

    // Resources:
    // https://www.youtube.com/watch?v=ZJUGtWObroc
    // https://www.youtube.com/watch?v=y2BD4MJqV20&list=TLPQMjQwOTIwMjCNKBD_ObHf6w&index=2
    override fun longestPalindrome(s: String): String {
        var startIndex = 0
        var endIndex = 0
        for (i in s.indices) {
            // 2 cases to handle:
            // - palindrome of odd length, like "abdba", where the middle element 'd' doesn't have a match
            // - regular palindrome of even length, like "abba", where each character has a match
            val odd = palindromeExpandingFromCenter(s, i, isOdd = true)
            val even = palindromeExpandingFromCenter(s, i, isOdd = false)
            val longer = if (odd.last - odd.first > even.last - even.first) odd else even
            if (longer.last - longer.first > endIndex - startIndex) {
                startIndex = longer.first
                endIndex = longer.last
            }
        }
        return s.substring(startIndex..endIndex)
    }

    private fun palindromeExpandingFromCenter(s: String, index: Int, isOdd: Boolean): IntRange {
        var l = index
        var r = if (isOdd) index else index + 1
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }
        // after loop is executed: ..., l, start, ..., end, r, ...
        return IntRange(l + 1, r - 1)
    }
}