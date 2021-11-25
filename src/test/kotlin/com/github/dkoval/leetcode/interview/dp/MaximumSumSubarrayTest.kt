package com.github.dkoval.leetcode.interview.dp

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumSumSubarrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4),
                // [4,-1,2,1] has the largest sum = 6.
                6
            ),
            Arguments.of(
                intArrayOf(1),
                1
            ),
            Arguments.of(
                intArrayOf(0),
                0
            ),
            Arguments.of(
                intArrayOf(-1),
                -1
            ),
            Arguments.of(
                intArrayOf(-2147483647),
                -2147483647
            )
        )
    }

    @Nested
    inner class MaximumSumSubarrayBruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the contiguous subarray (containing at least one number) which has the largest sum `(
            nums: IntArray,
            expected: Int
        ) {
            MaximumSumSubarrayBruteForce.test(nums, expected)
        }
    }

    @Nested
    inner class MaximumSumSubarrayDivideAndConquerTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the contiguous subarray (containing at least one number) which has the largest sum `(
            nums: IntArray,
            expected: Int
        ) {
            MaximumSumSubarrayDivideAndConquer.test(nums, expected)
        }
    }

    @Nested
    inner class MaximumSumSubarrayKadaneBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the contiguous subarray (containing at least one number) which has the largest sum `(
            nums: IntArray,
            expected: Int
        ) {
            MaximumSumSubarrayKadaneBottomUp.test(nums, expected)
        }
    }

    @Nested
    inner class MaximumSumSubarrayKadaneTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the contiguous subarray (containing at least one number) which has the largest sum `(
            nums: IntArray,
            expected: Int
        ) {
            MaximumSumSubarrayKadaneTopDown.test(nums, expected)
        }
    }

    private fun MaximumSumSubarray.test(nums: IntArray, expected: Int) {
        val actual = maxSubArray(nums)
        assertEquals(expected, actual)
    }
}