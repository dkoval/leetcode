package com.github.dkoval.leetcode.challenge

/**
 * [Search Insert Position](https://leetcode.com/problems/search-insert-position/)
 *
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 *
 * Constraints:
 * - ```1 <= nums.length <= 10^4```
 * - ```-10^4 <= nums[i] <= 10^4```
 * - nums contains distinct values sorted in ascending order
 * - ```-10^4 <= target <= 10^4```
 */
object SearchInsertPositionRev2 : SearchInsertPosition {

    override fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex
        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                target > nums[mid] -> left = mid + 1
                target < nums[mid] -> right = mid - 1
                else -> return mid
            }
        }
        return left
    }
}