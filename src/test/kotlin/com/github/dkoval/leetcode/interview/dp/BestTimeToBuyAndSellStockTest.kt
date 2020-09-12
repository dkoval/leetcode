package com.github.dkoval.leetcode.interview.dp

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BestTimeToBuyAndSellStockTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(7, 1, 5, 3, 6, 4),
                // Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
                // Not 7-1 = 6, as selling price needs to be larger than buying price.
                5
            ),
            Arguments.of(
                intArrayOf(7, 6, 4, 3, 1),
                // In this case, no transaction is done, i.e. max profit = 0.
                0
            )
        )
    }

    @Nested
    inner class BestTimeToBuyAndSellStockBruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the maximum profit`(prices: IntArray?, expected: Int) {
            BestTimeToBuyAndSellStockBruteForce.test(prices, expected)
        }
    }

    @Nested
    inner class BestTimeToBuyAndSellStockSinglePassTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the maximum profit`(prices: IntArray?, expected: Int) {
            BestTimeToBuyAndSellStockSinglePass.test(prices, expected)
        }
    }

    private fun BestTimeToBuyAndSellStock.test(prices: IntArray?, expected: Int) {
        val actual = maxProfit(prices)
        assertEquals(expected, actual)
    }
}