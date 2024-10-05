package com.github.dkoval.leetcode.challenge

object PermutationInStringRev1 : PermutationInString {

    private const val ALPHABET_SIZE = 26

    // O(l1 + 26 * (l2 - l1)) time | O(1) space - only counts1[] and counts2[] of size 26 are used
    override fun checkInclusion(s1: String, s2: String): Boolean {
        val l1 = s1.length
        val l2 = s2.length

        if (l1 > l2) {
            return false
        }

        // frequency table of string s1
        val counts1 = IntArray(ALPHABET_SIZE)
        // frequency table of a window of length l1 in string s2
        val counts2 = IntArray(ALPHABET_SIZE)
        for (i in 0 until l1) {
            counts1[s1[i] - 'a']++
            counts2[s2[i] - 'a']++
        }

        // sliding window: consider all windows of length l1 in string s2
        for (start in 0..(l2 - l1)) {
            if (start > 0) {
                // remove starting character of the previous windows from the frequency table of string s2
                counts2[s2[start - 1] - 'a']--
                // add ending character of the current window to the frequency table of string s2
                counts2[s2[start + l1 - 1] - 'a']++
            }
            if (matches(counts1, counts2)) {
                return true
            }
        }
        return false
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