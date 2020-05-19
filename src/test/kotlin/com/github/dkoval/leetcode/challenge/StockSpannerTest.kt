package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class StockSpannerTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                listOf(100, 80, 60, 70, 60, 75, 85),
                listOf(1, 1, 1, 2, 1, 4, 6)
            ),
            Arguments.of(
                listOf(28, 14, 28, 35, 46, 53, 66, 80, 87, 88),
                listOf(1, 1, 3, 4, 5, 6, 7, 8, 9, 10)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the span of the stock's price for the current day`(
        prices: List<Int>,
        expectedSpans: List<Int>
    ) {
        val spanner = StockSpanner()
        val actualSpans = prices.map { price -> spanner.next(price) }
        assertEquals(expectedSpans, actualSpans)
    }
}