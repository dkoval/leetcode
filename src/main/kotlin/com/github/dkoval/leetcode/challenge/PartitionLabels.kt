package com.github.dkoval.leetcode.challenge

/**
 * [Partition Labels](https://leetcode.com/explore/featured/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3448/)
 *
 * A string S of lowercase English letters is given. We want to partition this string into as many parts as possible
 * so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 */
object PartitionLabels {

    // Time complexity: O(N), space complexity: O(1)
    fun partitionLabels(S: String): List<Int> {
        val lastIndexOfLabel = mutableMapOf<Char, Int>()
        for (i in S.indices) {
            lastIndexOfLabel[S[i]] = i
        }
        var partitionStart = 0
        var partitionEnd = 0
        val result = mutableListOf<Int>()
        for (i in S.indices) {
            partitionEnd = maxOf(partitionEnd, lastIndexOfLabel[S[i]]!!)
            if (i == partitionEnd) {
                // reached the end of the current partition, hence
                // update the result and start a new partition
                result.add(partitionEnd - partitionStart + 1)
                partitionStart = i + 1
                partitionEnd = partitionStart
            }
        }
        return result
    }
}