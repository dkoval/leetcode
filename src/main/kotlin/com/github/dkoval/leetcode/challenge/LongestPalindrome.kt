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

    // O(N) time | O(ALPHA) space, where ALPHA is the number of characters in the alphabet
    fun longestPalindrome(s: String): Int {
        val counts = mutableMapOf<Char, Int>()
        for (c in s) {
            counts[c] = counts.getOrDefault(c, 0) + 1
        }

        // Example: "xbcbxxcxcx"
        // b -> 2
        // c -> 3 (odd)
        // candidate: "bcccb"
        // x -> 5 (odd) - can form a better palindrome "bcxxxxxcb"
        // take 2 "c" (instead of 3) and include 5 "x"
        // also note that it doesn't matter in which order we discover "c" and "x", in both cases we decrement answer by 1
        var ans = 0
        var oddCountFound = false
        for (count in counts.values) {
            ans += count
            if (count % 2 != 0) {
                ans--
                oddCountFound = true
            }
        }
        return if (oddCountFound) ans + 1 else ans
    }
}