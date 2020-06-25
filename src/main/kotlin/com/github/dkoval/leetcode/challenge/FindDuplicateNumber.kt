package com.github.dkoval.leetcode.challenge

/**
 * [Find the Duplicate Number](https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3371/)
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
 * find the duplicate one.
 *
 * Note:
 * - You must not modify the array (assume the array is read only).
 * - You must use only constant, O(1) extra space.
 * - Your runtime complexity should be less than O(n2).
 * - There is only one duplicate number in the array, but it could be repeated more than once.
 */
object FindDuplicateNumber {

    fun findDuplicate(nums: IntArray): Int {
        val n = nums.size
        for (i in nums.indices) {
            val idx = nums[i] % n
            nums[idx] += n
        }
        // find at which index max is occurring
        var maxVal = Int.MIN_VALUE
        var maxIdx = -1
        for (i in nums.indices) {
            if (nums[i] > maxVal) {
                maxVal = nums[i]
                maxIdx = i
            }
            // revert to original input array
            nums[i] %= n
        }
        return maxIdx
    }
}