package com.github.dkoval.leetcode.challenge

import kotlin.math.max

/**
 * [Contiguous Array](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3341/)
 *
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 */
object ContiguousArray {

    fun findMaxLength(nums: IntArray): Int {
        val countToIndexPairs = mutableMapOf<Int, Int>()
        var maxLength = 0
        var count = 0
        for (i in nums.indices) {
            count += if (nums[i] == 1) 1 else -1
            if (count == 0) {
                maxLength = i + 1
            } else {
                val index = countToIndexPairs[count]
                if (index != null) {
                    maxLength = max(maxLength, i - index)
                } else {
                    countToIndexPairs[count] = i
                }
            }
        }
        return maxLength
    }
}