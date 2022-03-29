package com.github.dkoval.leetcode.challenge

/**
 * [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number)
 *
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 * Constraints:
 * - 1 <= n <= 10^5
 * - nums.length == n + 1
 * - 1 <= nums(i) <= n
 * - All the integers in nums appear only once except for precisely one integer which appears two or more times
 */
object FindDuplicateNumber {

    fun findDuplicate(nums: IntArray): Int {
        val n = nums.size
        for (x in nums) {
            // map x from [1 : n] range to index from [0 : n - 1] range
            val idx = x % n - 1
            // don't worry, nums[] will be restored in the 2nd pass
            nums[idx] += n
        }

        // find at which index max occurs
        var maxVal = Int.MIN_VALUE
        var maxIdx = -1
        for (i in nums.indices) {
            if (nums[i] > maxVal) {
                maxVal = nums[i]
                maxIdx = i
            }
            // restore the original value at index i
            nums[i] %= n
        }

        // map index back to number
        return maxIdx + 1
    }
}