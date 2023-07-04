package com.github.dkoval.leetcode.challenge

/**
 * [Single Number II](https://leetcode.com/problems/single-number-ii/description/)
 *
 * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Constraints:
 *
 * - 1 <= nums.length <= 3 * 10^4
 * - -2^31 <= ```nums[i]``` <= 2^31 - 1
 * - Each element in nums appears exactly three times except for one element which appears once.
 */
object SingleNumber2 {

    // Resource: https://www.youtube.com/watch?v=ZbTXZ2_YAgI
    fun singleNumber(nums: IntArray): Int {
        // records bits which have occurred 1 time
        var ones = 0
        // records bits which have occurred 2 times
        var twos = 0
        for (x in nums) {
            // bits which have occurred 2 or 3 times
            twos = twos or (ones and x)
            // bits which have occurred 1 or 3 times
            ones = ones xor x
            // bits which have occurred exactly 3 times
            val common = ones and twos

            // fix phase - clear bits which have occurred exactly 3 times
            ones = ones and common.inv()
            twos = twos and common.inv()
        }
        return ones
    }
}