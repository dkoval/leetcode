package com.github.dkoval.leetcode.challenge

import java.util.*

/**
 * [Online Stock Span](https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3334/)
 *
 * Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of
 * that stock's price for the current day.
 *
 * The span of the stock's price today is defined as the maximum number of consecutive days
 * (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.
 *
 * For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then
 * the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 */
class StockSpanner {
    private val stack: Deque<PriceOnDay> = LinkedList()
    private var day = 0

    private class PriceOnDay(val price: Int, val day: Int)

    // Good read: https://algorithmsandme.com/stacks-stock-span-problem/
    fun next(price: Int): Int {
        day++
        if (day == 1) {
            stack.push(PriceOnDay(price, day))
            return 1
        }
        // Find the price on stack which is greater than current day's price
        while (!stack.isEmpty() && price >= stack.peek().price) {
            stack.pop()
        }
        val span = if (stack.isEmpty()) day else day - stack.peek().day
        stack.push(PriceOnDay(price, day))
        return span
    }
}