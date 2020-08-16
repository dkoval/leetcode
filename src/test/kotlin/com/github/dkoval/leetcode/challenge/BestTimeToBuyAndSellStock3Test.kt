package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BestTimeToBuyAndSellStock3Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            // Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
            // Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
            Arguments.of(
                intArrayOf(3, 3, 5, 0, 0, 3, 1, 4),
                6
            ),
            // Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
            // Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
            // engaging multiple transactions at the same time. You must sell before buying again.
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                4
            ),
            // In this case, no transaction is done, i.e. max profit = 0.
            Arguments.of(
                intArrayOf(7, 6, 4, 3, 1),
                0
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the maximum profit with at most 2 transactions allowed`(prices: IntArray, expected: Int) {
        val actual = BestTimeToBuyAndSellStock3.maxProfit(prices)
        assertEquals(expected, actual)
    }
}