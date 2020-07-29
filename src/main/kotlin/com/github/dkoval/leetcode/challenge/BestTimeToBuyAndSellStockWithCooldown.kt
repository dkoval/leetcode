package com.github.dkoval.leetcode.challenge

import kotlin.math.max

/**
 * [Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3405/)
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * - You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * - After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 */
object BestTimeToBuyAndSellStockWithCooldown {

    // Resource: https://www.youtube.com/watch?v=pkiJyNijgBw
    fun maxProfit(prices: IntArray): Int {
        if (prices.size <= 1) return 0
        var state1 = 0
        var state2 = -prices[0]
        var state3 = 0
        for (i in 1 until prices.size) {
            val prevState1 = state1
            val prevState2 = state2
            state1 = max(state1, state3)
            state2 = max(state2, prevState1 - prices[i])
            state3 = prevState2 + prices[i]
        }
        return max(state1, max(state2, state3))
    }
}