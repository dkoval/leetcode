package com.github.dkoval.leetcode.problems

/**
 * [Subarray Product Less Than K](https://leetcode.com/explore/featured/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3475/)
 *
 * Your are given an array of positive integers nums.
 *
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 */
interface SubarrayProductLessThanK {

    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int
}

object SubarrayProductLessThanKBruteForce : SubarrayProductLessThanK {

    override fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        var count = 0
        for (i in nums.indices) {
            var product = 1
            for (j in i until nums.size) {
                product *= nums[j]
                if (product < k) count++ else break
            }
        }
        return count
    }
}

// Time complexity: O(N), space complexity: O(1)
object SubarrayProductLessThanKUsingWindow : SubarrayProductLessThanK {

    // Resource: https://www.youtube.com/watch?v=bZQI58quN6E
    override fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        if (k <= 1) return 0
        var l = 0
        var count = 0
        var product = 1
        for (r in nums.indices) {
            product *= nums[r]
            // shift window's left boundary to make window's elements product < k
            while (product >= k) {
                // nothing better could be done with this index as the starting index
                product /= nums[l]
                l++
            }
            count += r - l + 1
        }
        return count
    }
}