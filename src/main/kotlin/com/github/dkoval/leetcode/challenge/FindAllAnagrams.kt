package com.github.dkoval.leetcode.challenge

/**
 * [Find All Anagrams in a String](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3332/)
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 */
object FindAllAnagrams {

    fun findAnagrams(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()
        for (i in 0..s.length - p.length) {
            val candidate = s.substring(i, i + p.length)
            if (areAnagrams(candidate, p)) {
                result.add(i)
            }
        }
        return result
    }

    private fun areAnagrams(str1: String, str2: String): Boolean {
        if (str1.length != str2.length) {
            return false
        }
        // strings consists of lowercase English letters only
        val frequencies = IntArray(26)
        for (i in str1.indices) {
            frequencies[str1[i] - 'a']++
            frequencies[str2[i] - 'a']--
        }
        return frequencies.all { frequency -> frequency == 0 }
    }
}