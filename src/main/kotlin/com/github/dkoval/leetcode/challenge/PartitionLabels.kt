package com.github.dkoval.leetcode.challenge

/**
 * [Partition Labels](https://leetcode.com/explore/featured/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3448/)
 *
 * A string S of lowercase English letters is given. We want to partition this string into as many parts as possible
 * so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 */
object PartitionLabels {

    // O(N) time | O(ALPHA) = 0(1) space, where ALPHA is the number of characters in the alphabet
    fun partitionLabels(S: String): List<Int> {
        // lastIdx[c] is the index of the last occurrence of character c in S
        val lastIdx = mutableMapOf<Char, Int>()
        for (i in S.indices) {
            lastIdx[S[i]] = i
        }

        var start = 0
        var end = 0
        val ans = mutableListOf<Int>()
        for (i in S.indices) {
            // try to expand the current partition further to the right
            end = maxOf(end, lastIdx[S[i]]!!)
            // is S[i] the last character of the current partition?
            if (i == end) {
                // reached the end of the current partition, hence
                // update the result and start a new partition
                ans.add(end - start + 1)
                start = i + 1
            }
        }
        return ans
    }
}