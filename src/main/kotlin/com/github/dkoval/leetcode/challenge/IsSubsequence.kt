package com.github.dkoval.leetcode.challenge

/**
 * [Is Subsequence](https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3355/)
 *
 * Given a string `s` and a string `t`, check if `s` is subsequence of `t`.
 */
object IsSubsequence {

    fun isSubsequence(s: String, t: String): Boolean {
        if (s.length > t.length) {
            return false
        }
        var i = 0
        var j = 0
        while (i < s.length && j < t.length) {
            if (s[i] == t[j]) {
                i++
            }
            j++
        }
        return i == s.length
    }
}