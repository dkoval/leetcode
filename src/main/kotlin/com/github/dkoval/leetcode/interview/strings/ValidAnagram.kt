package com.github.dkoval.leetcode.interview.strings

/**
 * [Valid Anagram](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/)
 *
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 */
object ValidAnagram {

    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val frequencies = mutableMapOf<Char, Int>()
        for (i in s.indices) {
            frequencies[s[i]] = frequencies.getOrDefault(s[i], 0) + 1
            frequencies[t[i]] = frequencies.getOrDefault(t[i], 0) - 1
        }
        return frequencies.all { (_, frequency) -> frequency == 0 }
    }
}