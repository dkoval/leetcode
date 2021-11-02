package com.github.dkoval.leetcode.challenge

/**
 * [Permutation in String](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/)
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 */
object PermutationInString {

    private const val ALPHABET_SIZE = 26

    // O(l1 + l1 * (l2 - l1)) time | O(1) space, only counts1[] and counts2[] of size 26 are used
    fun checkInclusion(s1: String, s2: String): Boolean {
        val l1 = s1.length
        val l2 = s2.length

        if (l1 > l2) {
            return false
        }

        val counts1 = counts(s1, 0, l1 - 1)
        // sliding window of size l1
        for (start in 0..(l2 - l1)) {
            val counts2 = counts(s2, start, start + l1 - 1)
            if (matches(counts1, counts2)) {
                return true
            }
        }
        return false
    }

    private fun counts(s: String, start: Int, end: Int): IntArray {
        val counts = IntArray(26)
        for (i in start..end) {
            counts[s[i] - 'a']++
        }
        return counts
    }

    private fun matches(counts1: IntArray, counts2: IntArray): Boolean {
        for (i in 0 until ALPHABET_SIZE) {
            if (counts1[i] != counts2[i]) {
                return false
            }
        }
        return true
    }
}