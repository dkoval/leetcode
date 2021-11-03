package com.github.dkoval.leetcode.challenge

/**
 * [Find All Anagrams in a String](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3332/)
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consist of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 */
object FindAllAnagramsInString {

    private const val ALPHABET_SIZE = 26

    // O(len(p) + 26 * (len(s) - len(p)) time | O(1) space - only 2 counts[] arrays of size 26 are used here
    fun findAnagrams(s: String, p: String): List<Int> {
        if (s.length < p.length) {
            return emptyList()
        }

        // frequency table of string p
        val pCounts = IntArray(ALPHABET_SIZE)
        // frequency table of the 1st window of size p.length in string s
        val wCounts = IntArray(ALPHABET_SIZE)
        for (i in p.indices) {
            pCounts[p[i] - 'a']++
            wCounts[s[i] - 'a']++
        }

        val result = mutableListOf<Int>()
        // sliding window - consider all windows of size p.length()
        for (start in 0..(s.length - p.length)) {
            if (start > 0) {
                // remove starting character of the previous window
                wCounts[s[start - 1] - 'a']--
                // add ending character of the current window
                wCounts[s[start + p.length - 1] - 'a']++
            }

            if (matches(wCounts, pCounts)) {
                result.add(start)
            }
        }
        return result
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