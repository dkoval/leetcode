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
        if (target < nums[0]) {
            return 0
        }
        if (target > nums.last()) {
            return nums.size
        }
        var l = 0
        var r = nums.lastIndex
        while (l < r) {
            val m = l + (r - l) / 2
            if (target > nums[m]) {
                l = m + 1
            } else {
                r = m
            }
        }
        return l
    }
}