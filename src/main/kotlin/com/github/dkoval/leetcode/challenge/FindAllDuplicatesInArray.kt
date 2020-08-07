package com.github.dkoval.leetcode.challenge

import kotlin.math.abs

/**
 * [Find All Duplicates in an Array](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3414/)
 *
 * Given an array of integers, ```1 ≤ a[i] ≤ n``` (n = size of array), some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 */
object FindAllDuplicatesInArray {

    // Resource: https://www.youtube.com/watch?v=8ci8WfQ6cns
    fun findDuplicates(nums: IntArray): List<Int> {
        val result = mutableListOf<Int>()
        for (num in nums) {
            val n = abs(num)
            if (nums[n - 1] > 0) {
                // 1st time
                nums[n - 1] *= -1
            } else {
                // 2nd time
                result.add(n)
            }
        }
        return result
    }
}