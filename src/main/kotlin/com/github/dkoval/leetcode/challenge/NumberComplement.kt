package com.github.dkoval.leetcode.challenge

/**
 * [Number Complement](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3319/)
 *
 * Given a positive integer num, output its complement number. The complement strategy is to flip the bits of its binary representation.
 *
 * Constraints:
 * 1 <= num < 2^31
 */
object NumberComplement {

    fun findComplement(num: Int): Int {
        var x = num
        var ans = 0
        var i = 0
        while (x != 0) {
            // take the least significant bit of x and flip it
            val bit = (x and 1) xor 1
            // set the flipped bit at the i-th position in the answer
            ans = ans or (bit shl i)
            x = x shr 1
            i++
        }
        return ans
    }
}