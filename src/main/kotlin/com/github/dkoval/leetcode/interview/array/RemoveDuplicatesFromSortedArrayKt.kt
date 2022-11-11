package com.github.dkoval.leetcode.interview.array

import com.github.dkoval.leetcode.problems.RemoveDuplicatesFromSortedArray

/**
 * [Remove Duplicates from Sorted Array](https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/727/)
 *
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */
object RemoveDuplicatesFromSortedArrayKt : RemoveDuplicatesFromSortedArray {

    override fun removeDuplicates(nums: IntArray): Int {
        var i = 0 // index of the last unique number
        for (j in 1 until nums.size) {
            if (nums[i] != nums[j]) {
                i++
                nums[i] = nums[j]
            }
        }
        return i + 1
    }
}