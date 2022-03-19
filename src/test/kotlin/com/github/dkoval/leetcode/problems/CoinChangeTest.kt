package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.CoinChange.CoinChangeBottomUp
import com.github.dkoval.leetcode.problems.CoinChange.CoinChangeTopDownWithMemoization
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CoinChangeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 5),
                11,
                3
            ),
            Arguments.of(
                intArrayOf(2),
                3,
                -1
            ),
            Arguments.of(
                intArrayOf(1),
                0,
                0
            ),
            Arguments.of(
                intArrayOf(1),
                1,
                1
            ),
            Arguments.of(
                intArrayOf(1),
                2,
                2
            )
        )
    }

    @Nested
    inner class CoinChangeTopDownWithMemoizationTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should compute the fewest number of coins that you need to make up that amount`(
            coins: IntArray,
            amount: Int,
            expected: Int
        ) {
            CoinChangeTopDownWithMemoization().test(coins, amount, expected)
        }
    }

    @Nested
    inner class CoinChangeBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should compute the fewest number of coins that you need to make up that amount`(
            coins: IntArray,
            amount: Int,
            expected: Int
        ) {
            CoinChangeBottomUp().test(coins, amount, expected)
        }
    }

    private fun CoinChange.test(coins: IntArray, amount: Int, expected: Int) {
        val actual = coinChange(coins, amount)
        assertEquals(expected, actual)
    }
}