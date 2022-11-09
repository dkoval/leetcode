package com.github.dkoval.leetcode.challenge

import java.util.*

/**
 * [Online Stock Span](https://leetcode.com/problems/online-stock-span/)
 *
 * Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of
 * that stock's price for the current day.
 *
 * The span of the stock's price today is defined as the maximum number of consecutive days
 * (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.
 *
 * For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then
 * the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 *
 * Constraints:
 * - 1 <= price <= 10^5
 * - At most 104 calls will be made to next.
 */
class StockSpanner {
    // monotonically decreasing stack, i.e. [Int.MAX_VALUE, 100, 80, ...]
    private val stack: Deque<PriceOnDay> = ArrayDeque()
    private var day: Int = 0

    init {
        stack.push(PriceOnDay(Int.MAX_VALUE, -1))
    }

    // Good read: https://algorithmsandme.com/stacks-stock-span-problem/
    fun next(price: Int): Int {
        // find the price on the stack which is strictly greater than current day's price
        while (!stack.isEmpty() && stack.peek().price <= price) {
            stack.pop()
        }

        val span = if (stack.isEmpty()) day + 1 else day - stack.peek().day
        stack.push(PriceOnDay(price, day))
        day++
        return span
    }
}

private data class PriceOnDay(val price: Int, val day: Int)