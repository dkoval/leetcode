package com.github.dkoval.leetcode.challenge

/**
 * [Best Time to Buy and Sell Stock III](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3426/)
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */
object BestTimeToBuyAndSellStock3 {

    fun maxProfit(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var maxProfitAfterFirstSell = 0
        var maxProfitAfterSecondBuy = Int.MIN_VALUE
        var maxProfitAfterSecondSell = 0
        for (price in prices) {
            minPrice = minOf(minPrice, price)
            maxProfitAfterFirstSell = maxOf(maxProfitAfterFirstSell, price - minPrice)
            maxProfitAfterSecondBuy = maxOf(maxProfitAfterSecondBuy, maxProfitAfterFirstSell - price)
            maxProfitAfterSecondSell = maxOf(maxProfitAfterSecondSell, price + maxProfitAfterSecondBuy)
        }
        return maxProfitAfterSecondSell
    }
}