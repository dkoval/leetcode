package com.github.dkoval.leetcode.interview.array

/**
 * [Longest Substring Without Repeating Characters](https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/779/)
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 */
object LongestSubstringWithoutRepeatingCharacters {

    // Time complexity: O(N)
    fun lengthOfLongestSubstring(s: String): Int {
        var maxLength = 0
        val charIndex = mutableMapOf<Char, Int>()
        var i = 0 // i - sliding window start index, j - sliding window end index
        for (j in s.indices) {
            val index = charIndex[s[j]]
            if (index != null) {
                i = maxOf(i, index + 1)
            }
            maxLength = maxOf(maxLength, j - i + 1)
            charIndex[s[j]] = j
        }
        return maxLength
    }
}