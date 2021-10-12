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
        var maxProdSoFar = nums[0]
        var minProdSoFar = nums[0]
        var bestMaxProd = nums[0]
        for (i in 1 until nums.size) {
            val prod1 = maxProdSoFar * nums[i]
            val prod2 = minProdSoFar * nums[i]
            maxProdSoFar = maxOf(nums[i], prod1, prod2)
            minProdSoFar = minOf(nums[i], prod1, prod2)
            bestMaxProd = maxOf(bestMaxProd, maxProdSoFar)
        }
        return bestMaxProd
    }
}