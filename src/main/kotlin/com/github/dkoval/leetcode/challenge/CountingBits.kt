package com.github.dkoval.leetcode.challenge

/**
 * [Counting Bits](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3343/)
 *
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's
 * in their binary representation and return them as an array.
 *
 * Follow up:
 * - It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * - Space complexity should be O(n).
 * - Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
object CountingBits {

    fun countBits(num: Int): IntArray {
        val bits = IntArray(num + 1)
        for (i in 1..num) {
            val half = i / 2
            bits[i] = if (i % 2 == 0) bits[half] else bits[half] + 1
        }
        return bits
    }
}