package com.github.dkoval.leetcode.interview.strings

/**
 * [Longest Common Prefix](https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/887/)
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Note:
 * - All given inputs are in lowercase letters a-z.
 */
interface LongestCommonPrefix {

    fun longestCommonPrefix(strs: Array<String>): String
}

object LongestCommonPrefixHorizontalScanning : LongestCommonPrefix {

    override fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        var prefix = strs[0]
        for (i in 1 until strs.size) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length - 1) // remove last character
                if (prefix.isEmpty()) return ""
            }
        }
        return prefix
    }
}

object LongestCommonPrefixVerticalScanning : LongestCommonPrefix {

    override fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        for (i in strs[0].indices) {
            val ch = strs[0][i]
            for (j in 1 until strs.size) {
                if (i == strs[j].length || strs[j][i] != ch) {
                    return strs[0].substring(0, i)
                }
            }
        }
        return strs[0]
    }
}