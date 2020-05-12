package com.github.dkoval.leetcode.interview.array

/**
 * [RotateArray](https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/646/)
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 */
object RotateArray {

    fun rotate(nums: IntArray, k: Int) {
        doRotate(nums, k % nums.size)
    }

    private fun doRotate(nums: IntArray, k: Int) {
        // reverse the entire array
        reverseInPlace(nums, 0, nums.size)
        // reverse the left portion of the array
        reverseInPlace(nums, 0, k)
        // reverse the right portion of the array
        reverseInPlace(nums, k, nums.size - k)
    }

    private fun reverseInPlace(nums: IntArray, offset: Int, count: Int) {
        for (i in 0 until count / 2) {
            val l = offset + i
            val r = offset + count - i - 1
            val tmp = nums[l]
            nums[l] = nums[r]
            nums[r] = tmp
        }
    }
}