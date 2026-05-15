package com.github.dkoval.leetcode.challenge

object FindMinimumInRotatedSortedArrayKt : FindMinimumInRotatedSortedArray {

    // Resource: https://www.youtube.com/watch?v=OXkLNPalfRs
    // O(logN) time | O(1) space
    override fun findMin(nums: IntArray): Int {
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