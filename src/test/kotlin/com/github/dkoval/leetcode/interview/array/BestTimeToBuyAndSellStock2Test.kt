package com.github.dkoval.leetcode.interview.array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BestTimeToBuyAndSellStock2Test {

    companion object {
        @JvmStatic
        fun input() = listOf<Arguments>(
            Arguments.of(intArrayOf(7, 1, 5, 3, 6, 4), 7),
            Arguments.of(intArrayOf(1, 2, 3, 4, 5), 4),
            Arguments.of(intArrayOf(7, 6, 4, 3, 1), 0),
            Arguments.of(intArrayOf(6, 1, 3, 2, 4, 7), 7)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the maximum profit`(prices: IntArray, expectedMaxProfit: Int) {
        val actualMaxProfit = BestTimeToBuyAndSellStock2.maxProfit(prices)
        assertEquals(expectedMaxProfit, actualMaxProfit)
    }
}