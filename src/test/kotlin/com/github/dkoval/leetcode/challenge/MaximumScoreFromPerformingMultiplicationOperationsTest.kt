package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumScoreFromPerformingMultiplicationOperations.MaximumScoreFromPerformingMultiplicationOperationsMLE
import com.github.dkoval.leetcode.challenge.MaximumScoreFromPerformingMultiplicationOperations.MaximumScoreFromPerformingMultiplicationOperationsSpaceOptimized
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumScoreFromPerformingMultiplicationOperationsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3),
                intArrayOf(3, 2, 1),
                14
            ),
            Arguments.of(
                intArrayOf(-5, -3, -3, -2, 7, 1),
                intArrayOf(-10, -5, 3, 4, 6),
                102
            )
        )
    }

    @Nested
    inner class MaximumScoreFromPerformingMultiplicationOperationsMLETest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum score after performing m operations`(
            nums: IntArray,
            multipliers: IntArray,
            expected: Int
        ) {
            MaximumScoreFromPerformingMultiplicationOperationsMLE().test(nums, multipliers, expected)
        }
    }

    @Nested
    inner class MaximumScoreFromPerformingMultiplicationOperationsSpaceOptimizedTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum score after performing m operations`(
            nums: IntArray,
            multipliers: IntArray,
            expected: Int
        ) {
            MaximumScoreFromPerformingMultiplicationOperationsSpaceOptimized().test(nums, multipliers, expected)
        }
    }

    private fun MaximumScoreFromPerformingMultiplicationOperations.test(
        nums: IntArray,
        multipliers: IntArray,
        expected: Int
    ) {
        val actual = maximumScore(nums, multipliers)
        assertEquals(expected, actual)
    }
}