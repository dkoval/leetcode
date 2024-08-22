package com.github.dkoval.leetcode.challenge

/**
 * [Number Complement](https://leetcode.com/problems/number-complement/)
 *
 * The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's
 * in its binary representation.
 *
 * For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
 *
 * Given an integer num, return its complement.
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