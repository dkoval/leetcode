package com.github.dkoval.leetcode.challenge

/**
 * [Permutation in String](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/)
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 */
object PermutationInString {

    fun checkInclusion(s1: String, s2: String): Boolean {
        for (i in 0..s2.length - s1.length) {
            val candidate = s2.substring(i, i + s1.length)
            if (arePermutations(candidate, s1)) {
                return true
            }
        }
        return false
    }

    private fun arePermutations(str1: String, str2: String): Boolean {
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