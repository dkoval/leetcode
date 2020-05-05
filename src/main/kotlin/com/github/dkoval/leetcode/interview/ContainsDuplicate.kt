package com.github.dkoval.leetcode.interview

/**
 * [Contains Duplicate](https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/578/)
 *
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */
object ContainsDuplicate {

    fun containsDuplicate(nums: IntArray): Boolean {
        val alreadySeen = mutableSetOf<Int>()
        for (num in nums) {
            if (num in alreadySeen) {
                return true
            } else {
                alreadySeen.add(num)
            }
        }
        return false
    }
}