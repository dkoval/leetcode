package com.github.dkoval.leetcode.challenge

import kotlin.math.abs

/**
 * [First Missing Positive](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/558/week-5-september-29th-september-30th/3478/)
 *
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Follow up:
 * - Your algorithm should run in O(n) time and uses constant extra space.
 */
interface FirstMissingPositive {

    fun firstMissingPositive(nums: IntArray): Int
}

object FirstMissingPositiveBruteForce : FirstMissingPositive {

    override fun firstMissingPositive(nums: IntArray): Int {
        for (i in 1..nums.size) {
            var found = false
            for (num in nums) {
                if (num == i) {
                    found = true
                    break
                }
            }
            if (!found) return i
        }
        return nums.size + 1
    }
}

object FirstMissingPositiveInLinearTimeUsingHashSet : FirstMissingPositive {

    override fun firstMissingPositive(nums: IntArray): Int {
        val numsSet = nums.toSet()
        for (i in 1..nums.size) {
            if (i !in numsSet) return i
        }
        return nums.size + 1
    }
}

object FirstMissingPositiveInLinearTimeAndConstantSpace : FirstMissingPositive {

    // Resource: https://www.youtube.com/watch?v=L1u-R_s2Mok
    override fun firstMissingPositive(nums: IntArray): Int {
        var foundOne = false
        for (num in nums) {
            if (num == 1) {
                foundOne = true
                break
            }
        }
        if (!foundOne) return 1
        if (nums.size == 1) return 2
        // convert numbers such that all of them are in 1..n range
        for (i in nums.indices) {
            if (nums[i] <= 0 || nums[i] > nums.size) {
                nums[i] = 1
            }
        }
        // make all positive numbers in the array negative to mark them visited
        for (i in nums.indices) {
            val idx = abs(nums[i]) - 1
            if (nums[idx] > 0) {
                nums[idx] *= -1
            }
        }
        // first encountered positive number's index + 1 will denote the smallest missing positive number
        for (i in nums.indices) {
            if (nums[i] > 0) return i + 1
        }
        return nums.size + 1
    }
}