package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.BestTimeToBuyAndSellStockWithTransactionFee.BestTimeToBuyAndSellStockWithTransactionFeeDPBottomUp
import com.github.dkoval.leetcode.problems.BestTimeToBuyAndSellStockWithTransactionFee.BestTimeToBuyAndSellStockWithTransactionFeeDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BestTimeToBuyAndSellStockWithTransactionFeeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 2, 8, 4, 9),
                2,
                // ((8 - 1) - 2) + ((9 - 4) - 2) = 8
                8
            ),
            Arguments.of(
                intArrayOf(1, 3, 7, 5, 10, 3),
                3,
                6
            )
        )
    }

    @Nested
    inner class BestTimeToBuyAndSellStockWithTransactionFeeDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum profit you can achieve`(prices: IntArray, fee: Int, expected: Int) {
            BestTimeToBuyAndSellStockWithTransactionFeeDPTopDown().test(prices, fee, expected)
        }
    }

    @Nested
    inner class BestTimeToBuyAndSellStockWithTransactionFeeDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum profit you can achieve`(prices: IntArray, fee: Int, expected: Int) {
            BestTimeToBuyAndSellStockWithTransactionFeeDPBottomUp().test(prices, fee, expected)
        }
    }

    private fun BestTimeToBuyAndSellStockWithTransactionFee.test(prices: IntArray, fee: Int, expected: Int) {
        val actual = maxProfit(prices, fee)
        assertEquals(expected, actual)
    }
}