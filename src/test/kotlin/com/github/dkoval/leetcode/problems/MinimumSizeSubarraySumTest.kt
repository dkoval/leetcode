package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.MinimumSizeSubarraySum.MinimumSizeSubarraySumBruteForceWithPrefixSum
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumSizeSubarraySumTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                7,
                intArrayOf(2, 3, 1, 2, 4, 3),
                2
            ),
            Arguments.of(
                4,
                intArrayOf(1, 4, 4),
                1
            ),
            Arguments.of(
                11,
                intArrayOf(1, 1, 1, 1, 1, 1, 1, 1),
                0
            )
        )
    }

    @Nested
    inner class MinimumSizeSubarraySumBruteForceWithPrefixSumTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimal length of a contiguous subarray with sum greater or equal to target`(
            target: Int,
            nums: IntArray,
            expected: Int
        ) {
            MinimumSizeSubarraySumBruteForceWithPrefixSum().test(target, nums, expected)
        }
    }

    private fun MinimumSizeSubarraySum.test(target: Int, nums: IntArray, expected: Int) {
        val actual = minSubArrayLen(target, nums)
        assertEquals(expected, actual)
    }
}