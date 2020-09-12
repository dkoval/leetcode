package com.github.dkoval.leetcode.interview.dp

/**
 * [Best Time to Buy and Sell Stock](https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/572/)
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 */
interface BestTimeToBuyAndSellStock {

    fun maxProfit(prices: IntArray?): Int
}

// Time complexity: O(N^2), space complexity: O(1)
object BestTimeToBuyAndSellStockBruteForce : BestTimeToBuyAndSellStock {

    override fun maxProfit(prices: IntArray?): Int {
        if (prices == null) return 0
        // the find the maximum profit, consider all
        // (prices[j], prices[i]) pairs, where j > i
        var maxProfit = 0
        for (i in 0 until prices.size - 1) {
            for (j in i + 1 until prices.size) {
                maxProfit = maxOf(maxProfit, prices[j] - prices[i])
            }
        }
        return maxProfit
    }
}

// Time complexity: O(N), space complexity: O(1)
object BestTimeToBuyAndSellStockSinglePass : BestTimeToBuyAndSellStock {

    override fun maxProfit(prices: IntArray?): Int {
        if (prices == null) return 0
        // We need to find the largest peak following the smallest valley
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0
        for (price in prices) {
            maxProfit = maxOf(maxProfit, price - minPrice)
            minPrice = minOf(minPrice, price)
        }
        return maxProfit
    }
}