package com.github.dkoval.leetcode.interview.array

/**
 * [Longest Substring Without Repeating Characters](https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/779/)
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 */
object LongestSubstringWithoutRepeatingCharacters {

    fun lengthOfLongestSubstring(s: String): Int {
        var maxLength = 0
        val seen = mutableSetOf<Char>()
        for (i in s.indices) {
            for (j in i until s.length) {
                if (s[j] in seen) {
                    maxLength = maxOf(maxLength, seen.size)
                    seen.clear()
                    break
                } else {
                    seen += s[j]
                }
            }
        }
        maxLength = maxOf(maxLength, seen.size)
        return maxLength
    }
}