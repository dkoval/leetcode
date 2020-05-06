package com.github.dkoval.leetcode.interview

/**
 * [Single Number](https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/549/)
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
object SingleNumber {

    fun singleNumber(nums: IntArray): Int {
        var single = 0
        for (element in nums) {
            single = single xor element
        }
        return single
    }
}