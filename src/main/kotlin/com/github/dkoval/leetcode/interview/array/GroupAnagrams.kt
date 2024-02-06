package com.github.dkoval.leetcode.interview.array

/**
 * [Group Anagrams](https://leetcode.com/problems/group-anagrams/)
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Constraints:
 *
 * - ```1 <= strs.length <= 10^4```
 * - ```0 <= strs[i].length <= 100```
 * - ```strs[i] consists of lowercase English letters```
 */
interface GroupAnagrams {

    fun groupAnagrams(strs: Array<String>): List<List<String>>
}

object GroupAnagramsKt : GroupAnagrams {

    // Time Complexity: O(N*K), where N is the length of strs, and K is the maximum length of a string in strs.
    // Counting each string is linear in the size of the string, and we count every string.
    // Space Complexity: O(N), the total information content stored in `groups` map.
    override fun groupAnagrams(strs: Array<String>): List<List<String>> {
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