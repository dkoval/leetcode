package com.github.dkoval.leetcode.challenge

/**
 * [Power of Two](https://leetcode.com/problems/power-of-two/)
 *
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 *
 * An integer n is a power of two, if there exists an integer x such that n == 2^x.
 *
 * Constraints:
 *
 * -2^31 <= n <= 2^31 - 1
 */
object PowerOfTwo {

    fun isPowerOfTwo(n: Int): Boolean =
        if (n == 0 || n == Int.MIN_VALUE) {
            false
        } else {
            n and (n - 1) == 0
        }
}