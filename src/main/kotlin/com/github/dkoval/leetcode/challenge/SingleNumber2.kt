package com.github.dkoval.leetcode.challenge

/**
 * [Single Number II](https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3368/)
 *
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once.
 * Find that single one.
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
object SingleNumber2 {

    // Resource: https://www.youtube.com/watch?v=ZbTXZ2_YAgI
    fun singleNumber(nums: IntArray): Int {
        var ones = 0 // bits which have occurred 1 time
        var twos = 0 // bits which have occurred 2 times
        for (n in nums) {
            twos = twos or (ones and n) // bits which have occurred 2 or 3 times
            ones = ones xor n // bits which have occurred 1 or 3 times
            val threes = twos and ones // bits which have occurred 3 times
            // fix phase - clear bits which have occurred 3 times
            twos = twos and threes.inv()
            ones = ones and threes.inv()
        }
        return ones
    }
}