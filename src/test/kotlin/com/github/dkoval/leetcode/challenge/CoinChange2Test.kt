package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CoinChange2.CoinChange2TopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CoinChange2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            // 5=5
            // 5=2+2+1
            // 5=2+1+1+1
            // 5=1+1+1+1+1
            Arguments.of(
                5,
                intArrayOf(1, 2, 5),
                4
            ),
            Arguments.of(
                3,
                intArrayOf(2),
                0
            ),
            Arguments.of(
                10,
                intArrayOf(10),
                1
            )
        )
    }

    @Nested
    inner class  CoinChange2TopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should compute the number of combinations`(amount: Int, coins: IntArray, expected: Int) {
            CoinChange2TopDown().test(amount, coins, expected)
        }
    }

    @Nested
    inner class  CoinChange2BottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should compute the number of combinations`(amount: Int, coins: IntArray, expected: Int) {
            CoinChange2BottomUp.test(amount, coins, expected)
        }
    }

    private fun CoinChange2.test(amount: Int, coins: IntArray, expected: Int) {
        val actual = change(amount, coins)
        assertEquals(expected, actual)
    }
}