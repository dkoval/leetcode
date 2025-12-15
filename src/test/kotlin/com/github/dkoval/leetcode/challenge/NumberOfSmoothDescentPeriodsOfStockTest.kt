package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfSmoothDescentPeriodsOfStock.NumberOfSmoothDescentPeriodsOfStockRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfSmoothDescentPeriodsOfStockTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 2, 1, 4),
                7L
            ),
            Arguments.of(
                intArrayOf(8, 6, 7, 7),
                4L
            ),
            Arguments.of(
                intArrayOf(1),
                1L
            )
        )
    }

    @Nested
    inner class NumberOfSmoothDescentPeriodsOfStockRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of smooth descent periods of stock`(
            prices: IntArray,
            expected: Long
        ) {
            NumberOfSmoothDescentPeriodsOfStockRev1().test(prices, expected)
        }
    }
}

private fun NumberOfSmoothDescentPeriodsOfStock.test(prices: IntArray, expected: Long) {
    val actual = getDescentPeriods(prices)
    assertEquals(expected, actual)
}
