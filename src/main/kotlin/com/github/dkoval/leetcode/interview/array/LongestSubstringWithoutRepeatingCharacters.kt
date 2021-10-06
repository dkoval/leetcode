package com.github.dkoval.leetcode.interview.array

/**
 * [Longest Substring Without Repeating Characters](https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/779/)
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 */
object LongestSubstringWithoutRepeatingCharacters {

    // O(N) time | O(N) space
    fun lengthOfLongestSubstring(s: String): Int {
        var maxLength = 0
        val window = mutableMapOf<Char, Int>()
        var start = 0
        for (end in s.indices) {
            val c = s[end]
            if (c in window) {
                val idx = window[c]!!
                // shrink the window, i.e. ignore characters before s[idx + 1]
                start = maxOf(start, idx + 1)
            }
            window[c] = end
            maxLength = maxOf(maxLength, end - start + 1)
        }
        return maxLength
    }
}