package com.github.dkoval.leetcode.challenge

object LongestPalindromeRev1 : LongestPalindrome {

    // O(N) time | O(ALPHA) space, where ALPHA is the number of characters in the alphabet
    override fun longestPalindrome(s: String): Int {
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