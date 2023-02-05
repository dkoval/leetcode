package com.github.dkoval.leetcode.challenge

/**
 * [Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/)
 *
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * Constraints:
 *
 * - 1 <= s.length, p.length <= 3 * 104
 * - s and p consist of lowercase English letters.
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

        val ans = mutableListOf<Int>()
        // sliding window - consider all windows of size p.length()
        for (start in 0..(s.length - p.length)) {
            if (start > 0) {
                // remove starting character of the previous window
                wCounts[s[start - 1] - 'a']--
                // add ending character of the current window
                wCounts[s[start + p.length - 1] - 'a']++
            }

            if (matches(wCounts, pCounts)) {
                ans.add(start)
            }
        }
        return ans
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