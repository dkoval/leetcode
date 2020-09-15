package com.github.dkoval.leetcode.interview.array

/**
 * [Group Anagrams](https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/778/)
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
object GroupAnagrams {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val groups = mutableMapOf<String, MutableList<String>>()
        for (str in strs) {
            val key = keyOf(str)
            groups.getOrPut(key) { mutableListOf() } += str
        }
        return groups.values.toList()
    }

    private fun keyOf(str: String): String {
        val counts = IntArray(26)
        for (c in str) {
            counts[c - 'a']++
        }
        return buildString {
            for (i in counts.indices) {
                if (counts[i] == 0) continue
                append('a' + i)
                append(counts[i])
            }
        }
    }
}