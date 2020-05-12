package com.github.dkoval.leetcode.interview.array

/**
 * [Move Zeros](https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/)
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note:
 * - You must do this in-place without making a copy of the array.
 * - Minimize the total number of operations
 */
object MoveZeros {

    fun moveZeroes(nums: IntArray) {
        var i = 0
        for (j in nums.indices) {
            if (nums[j] != 0) {
                nums.swap(i, j)
                i++
            }
        }
    }

    private fun IntArray.swap(i: Int, j: Int) {
        if (i != j) {
            val tmp = this[i]
            this[i] = this[j]
            this[j] = tmp
        }
    }
}