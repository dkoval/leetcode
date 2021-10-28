package com.github.dkoval.leetcode.challenge

/**
 * [Search Insert Position](https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3356/)
 *
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
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