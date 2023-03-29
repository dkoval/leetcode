package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ReducingDishes.ReducingDishesRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ReducingDishesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(-1, -8, 0, 5, -9),
                14
            ),
            Arguments.of(
                intArrayOf(4, 3, 2),
                20
            ),
            Arguments.of(
                intArrayOf(-1, -4, -5),
                0
            )
        )
    }

    @Nested
    inner class ReducingDishesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum sum of like-time coefficient that the chef can obtain after dishes preparation`(
            satisfaction: IntArray,
            expected: Int
        ) {
            ReducingDishesRev1().test(satisfaction, expected)
        }
    }
}

private fun ReducingDishes.test(satisfaction: IntArray, expected: Int) {
    val actual = maxSatisfaction(satisfaction)
    assertEquals(expected, actual)
}
