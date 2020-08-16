package com.github.dkoval.leetcode.challenge

/**
 * [Longest Palindrome](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3423/)
 *
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that
 * can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 */
object LongestPalindrome {

    fun longestPalindrome(s: String): Int {
        val counts = mutableMapOf<Char, Int>()
        for (ch in s) {
            counts[ch] = counts.getOrDefault(ch, 0) + 1
        }
        var result = 0
        var oddFound = false
        for ((_, count) in counts) {
            result += count
            if (count % 2 != 0) {
                result--
                oddFound = true
            }
        }
        return if (oddFound) result + 1 else result
    }
}