package com.github.dkoval.leetcode.challenge

/**
 * [Reverse Bits](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3388/)
 *
 * Reverse bits of a given 32 bits unsigned integer.
 */
object ReverseBits {

    fun reverseBits(n: Int): Int {
        var reversed = 0
        var bits = n
        var pos = 0
        while (bits != 0) {
            val bit = bits and 1
            reversed = reversed or (bit shl (31 - pos))
            bits = bits ushr 1
            pos++
        }
        return reversed
    }
}