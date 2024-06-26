package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit.LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimitRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimitTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(8, 2, 4, 7),
                4,
                2
            ),
            Arguments.of(
                intArrayOf(10, 1, 2, 4, 7, 2),
                5,
                4
            ),
            Arguments.of(
                intArrayOf(4, 2, 2, 2, 4, 4, 2, 2),
                0,
                3
            )
        )
    }

    @Nested
    inner class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimitRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit`(
            nums: IntArray,
            limit: Int,
            expected: Int
        ) {
            LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimitRev1().test(nums, limit, expected)
        }
    }
}

private fun LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit.test(
    nums: IntArray,
    limit: Int,
    expected: Int
) {
    val actual = longestSubarray(nums, limit)
    assertEquals(expected, actual)
}
