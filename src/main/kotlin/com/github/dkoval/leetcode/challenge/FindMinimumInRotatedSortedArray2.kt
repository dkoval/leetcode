package com.github.dkoval.leetcode.challenge

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., ```[0,1,2,4,5,6,7]``` might become ```[4,5,6,7,0,1,2]```).
 *
 * Find the minimum element.
 * The array may contain duplicates.
 */
object FindMinimumInRotatedSortedArray2 {

    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.lastIndex
        while (l < r) {
            val mid = l + (r - l) / 2
            when {
                nums[mid] > nums[r] -> l = mid + 1
                nums[mid] < nums[r] -> r = mid
                else -> r--
            }
        }
        return nums[l]
    }
}