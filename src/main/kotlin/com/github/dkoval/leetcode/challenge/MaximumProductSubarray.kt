package com.github.dkoval.leetcode.challenge

/**
 * [Maximum Product Subarray](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3456/)
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 */
object MaximumProductSubarray {

    // Time complexity 0(N), space complexity: O(1)
    fun maxProduct(nums: IntArray): Int {
        var maxProductOverall = nums[0]
        var maxProductEndingHere = nums[0]
        var minProductEndingHere = nums[0]
        for (i in 1 until nums.size) {
            val tmp = maxProductEndingHere
            maxProductEndingHere = maxOf(nums[i], tmp * nums[i], minProductEndingHere * nums[i])
            minProductEndingHere = minOf(nums[i], tmp * nums[i], minProductEndingHere * nums[i])
            maxProductOverall = maxOf(maxProductOverall, maxProductEndingHere)
        }
        return maxProductOverall
    }
}