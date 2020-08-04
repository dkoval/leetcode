package com.github.dkoval.leetcode.challenge

/**
 * [Power of Four](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3412/)
 *
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Follow up: Could you solve it without loops/recursion?
 */
object PowerOfFour {

    fun isPowerOfFour(num: Int): Boolean {
        if (num == 0 || num == Int.MIN_VALUE) {
            return false
        }
        return (num and (num - 1) == 0) && // power of 2 check
                (num and 0xAAAAAAAA.toInt() == 0) // filter out 2, 8, 32, ...
    }
}