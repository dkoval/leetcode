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
        var profitInState1 = 0
        var profitInState2 = -prices[0]
        var profitInState3 = 0
        for (i in 1 until prices.size) {
            val prevProfitInState1 = profitInState1
            val prevProfitInState2 = profitInState2
            profitInState1 = max(profitInState1, profitInState3)
            profitInState2 = max(profitInState2, prevProfitInState1 - prices[i])
            profitInState3 = prevProfitInState2 + prices[i]
        }
        return max(profitInState1, max(profitInState2, profitInState3))
    }
}