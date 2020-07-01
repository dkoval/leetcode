package com.github.dkoval.leetcode.challenge

import kotlin.math.sqrt

/**
 * [Arranging Coins](https://leetcode.com/explore/featured/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3377/)
 *
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 */
interface ArrangingCoins {

    fun arrangeCoins(n: Int): Int
}

object ArrangingCoinsIter: ArrangingCoins {

    override fun arrangeCoins(n: Int): Int {
        var rem = n
        var k = 1
        while (rem >= k) {
            rem -= k
            k++
        }
        return k - 1
    }
}

object ArrangingCoinsMath: ArrangingCoins {

    override fun arrangeCoins(n: Int): Int {
        // find max k so that S[k] <= n, where
        // S[k] = 1 + 2 + ... + k = k * (k + 1) / 2
        // k is a positive root of k^2 + k - 2 * n = 0 equation
        return (-1 + sqrt(1.0 + 8L * n).toInt()) / 2
    }
}