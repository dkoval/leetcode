package com.github.dkoval.leetcode.challenge

/**
 * [Arranging Coins](https://leetcode.com/explore/featured/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3377/)
 *
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 */
object ArrangingCoins {

    fun arrangeCoins(n: Int): Int {
        var rem = n
        var k = 1
        while (rem >= k) {
            rem -= k
            k++
        }
        return k - 1
    }
}