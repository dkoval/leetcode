package com.github.dkoval.leetcode.interview.array

/**
 * [Best Time to Buy and Sell Stock II](https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/564/)
 *
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */
object BestTimeToBuyAndSellStock2 {

    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        for (i in 1 until prices.size) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1]
            }
        }
        return maxProfit
    }
}