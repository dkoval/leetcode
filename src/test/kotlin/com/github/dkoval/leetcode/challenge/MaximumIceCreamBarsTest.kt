package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumIceCreamBars.MaximumIceCreamBarsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumIceCreamBarsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 2, 4, 1),
                7,
                4
            ),
            Arguments.of(
                intArrayOf(10, 6, 8, 7, 7, 8),
                5,
                0
            ),
            Arguments.of(
                intArrayOf(1, 6, 3, 1, 2, 5),
                20,
                6
            )
        )
    }

    @Nested
    inner class MaximumIceCreamBarsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of ice cream bars the boy can buy with coins coins`(
            costs: IntArray,
            coins: Int,
            expected: Int
        ) {
            MaximumIceCreamBarsRev1().test(costs, coins, expected)
        }
    }

    private fun MaximumIceCreamBars.test(costs: IntArray, coins: Int, expected: Int) {
        val actual = maxIceCream(costs, coins)
        assertEquals(expected, actual)
    }
}