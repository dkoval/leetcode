package com.github.dkoval.leetcode.challenge

/**
 * [Number Complement](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3319/)
 *
 * Given a positive integer num, output its complement number. The complement strategy is to flip the bits of its binary representation.
 */
object NumberComplement {

    fun findComplement(num: Int): Int {
        var x = num
        var answer = 0
        var count = 0
        while (x != 0) {
            val lastBit = x % 2
            val invertedLastBit = if (lastBit == 0) 1 else 0
            answer = answer or (invertedLastBit shl count++)
            x /= 2
        }
        return answer
    }
}