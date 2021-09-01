package com.github.dkoval.leetcode.challenge

/**
 * [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., ```[0,1,2,4,5,6,7]``` might become ```[4,5,6,7,0,1,2]```).
 *
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 */
object FindMinimumInRotatedSortedArray {

    // Resource: https://www.youtube.com/watch?v=OXkLNPalfRs
    // O(logN) time | O(1) space
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.lastIndex
        while (l < r) {
            val mid = l + (r - l) / 2
            when {
                nums[mid] > nums[r] -> l = mid + 1
                nums[mid] < nums[r] -> r = mid
                else -> return nums[mid]
            }
        }
        return nums[l]
    }
}