package com.github.dkoval.leetcode.challenge

/**
 * [Power of Two](https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3354/)
 *
 * Given an integer, write a function to determine if it is a power of two.
 */
object PowerOfTwo {

    fun isPowerOfTwo(n: Int): Boolean =
        if (n == 0 || n == Int.MIN_VALUE) {
            false
        } else {
            n and (n - 1) == 0
        }
}