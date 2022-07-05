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
object SearchInsertPosition {

    fun searchInsert(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.lastIndex
        while (l <= r) {
            val mid = l + (r - l) / 2
            when {
                target > nums[mid] -> {
                    l = mid + 1
                }
                target < nums[mid] -> {
                    r = mid - 1
                }
                else -> {
                    return mid
                }
            }
        }
        return l
    }
}