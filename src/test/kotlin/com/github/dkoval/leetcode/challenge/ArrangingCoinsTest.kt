package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ArrangingCoinsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> =
            Stream.of(
                Arguments.of(1, 1),
                Arguments.of(5, 2),
                Arguments.of(8, 3),
                Arguments.of(1804289383, 60070)
            )
    }

    @Nested
    inner class ArrangingCoinsIterTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the total number of full staircase rows that can be formed`(n: Int, expected: Int) {
            ArrangingCoinsIter.test(n, expected)
        }
    }

    @Nested
    inner class ArrangingCoinsMathTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the total number of full staircase rows that can be formed`(n: Int, expected: Int) {
            ArrangingCoinsMath.test(n, expected)
        }
    }

    private fun ArrangingCoins.test(n: Int, expected: Int) {
        val actual = arrangeCoins(n)
        assertEquals(expected, actual)
    }
}