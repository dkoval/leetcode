package com.github.dkoval.leetcode.challenge

/**
 * [Add Digits](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3402/)
 *
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * Could you do it without any loop/recursion in O(1) runtime?
 */
object AddDigits {

    // Resources:
    // https://en.wikipedia.org/wiki/Digital_root
    // https://www.youtube.com/watch?v=tIjdI-ioXh0
    fun addDigits(num: Int): Int = when {
        num == 0 -> 0
        num % 9 == 0 -> 9
        else -> num % 9
    }
}