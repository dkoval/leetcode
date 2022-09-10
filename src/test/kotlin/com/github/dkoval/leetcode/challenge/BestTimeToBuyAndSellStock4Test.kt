package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.BestTimeToBuyAndSellStock4.BestTimeToBuyAndSellStock4DPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BestTimeToBuyAndSellStock4Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                2,
                intArrayOf(2, 4, 1),
                2
            ),
            Arguments.of(
                2,
                intArrayOf(3, 2, 6, 5, 0, 3),
                7
            )
        )
    }

    @Nested
    inner class BestTimeToBuyAndSellStock4DPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the max profit we can make by completing at most k transactions`(
            k: Int,
            prices: IntArray,
            expected: Int
        ) {
            BestTimeToBuyAndSellStock4DPTopDown().test(k, prices, expected)
        }
    }

    private fun BestTimeToBuyAndSellStock4.test(k: Int, prices: IntArray, expected: Int) {
        val actual = maxProfit(k, prices)
        assertEquals(expected, actual)
    }
}