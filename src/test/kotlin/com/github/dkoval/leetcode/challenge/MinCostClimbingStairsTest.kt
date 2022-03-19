package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinCostClimbingStairs.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinCostClimbingStairsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(10, 15, 20),
                15
            ),
            Arguments.of(
                intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1),
                6
            )
        )
    }

    @Nested
    inner class MinCostClimbingStairsTopDownWithMemoizationTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum cost to reach the top of the floor`(cost: IntArray, expected: Int) {
            MinCostClimbingStairsTopDownWithMemoization().test(cost, expected)
        }
    }

    @Nested
    inner class MinCostClimbingStairsBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum cost to reach the top of the floor`(cost: IntArray, expected: Int) {
            MinCostClimbingStairsBottomUp().test(cost, expected)
        }
    }

    @Nested
    inner class MinCostClimbingStairsBottomUpSpaceOptimizedTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum cost to reach the top of the floor`(cost: IntArray, expected: Int) {
            MinCostClimbingStairsBottomUpSpaceOptimized().test(cost, expected)
        }
    }

    private fun MinCostClimbingStairs.test(cost: IntArray, expected: Int) {
        val actual = minCostClimbingStairs(cost)
        assertEquals(expected, actual)
    }
}