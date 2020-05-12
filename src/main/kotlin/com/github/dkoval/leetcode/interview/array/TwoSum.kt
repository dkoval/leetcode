package com.github.dkoval.leetcode.interview.array

/**
 * [Two Sum](https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/)
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
object TwoSum {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val alreadySeen = mutableMapOf(nums[0] to 0)
        for (j in 1 until nums.size) {
            val x = nums[j]
            val diff = target - x
            val i = alreadySeen[diff]
            if (i != null) {
                return intArrayOf(i, j)
            }
            alreadySeen[x] = j
        }
        throw IllegalStateException("Could not find two numbers that add up to $target")
    }
}