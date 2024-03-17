package com.github.dkoval.leetcode.challenge

import kotlin.math.max

object ContiguousArrayRev1 : ContiguousArray {

    override fun findMaxLength(nums: IntArray): Int {
        // stores relative number of 1's and 0's encountered so far while
        var count = 0
        var maxLength = 0
        val countToIndex = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            count += if (nums[i] == 1) 1 else -1
            if (count == 0) {
                maxLength = i + 1
            } else {
                if (count in countToIndex) {
                    // there's equal number of 1's and 0's in nums[idx + 1 : i] subarray
                    val idx = countToIndex[count]!!
                    maxLength = max(maxLength, i - idx)
                } else {
                    countToIndex[count] = i
                }
            }
        }
        return maxLength
    }
}