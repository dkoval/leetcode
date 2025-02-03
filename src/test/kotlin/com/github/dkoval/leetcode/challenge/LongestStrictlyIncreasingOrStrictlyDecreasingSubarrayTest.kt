package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LongestStrictlyIncreasingOrStrictlyDecreasingSubarray.LongestStrictlyIncreasingOrStrictlyDecreasingSubarrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LongestStrictlyIncreasingOrStrictlyDecreasingSubarrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 4, 3, 3, 2),
                2
            ),
            Arguments.of(
                intArrayOf(3, 3, 3, 3),
                1
            ),
            Arguments.of(
                intArrayOf(3, 2, 1),
                3
            )
        )
    }

    @Nested
    inner class LongestStrictlyIncreasingOrStrictlyDecreasingSubarrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest subarray that is either strictly increasing or strictly decreasing`(
            nums: IntArray,
            expected: Int
        ) {
            LongestStrictlyIncreasingOrStrictlyDecreasingSubarrayRev1().test(nums, expected)
        }
    }
}

private fun LongestStrictlyIncreasingOrStrictlyDecreasingSubarray.test(nums: IntArray, expected: Int) {
    val actual = longestMonotonicSubarray(nums)
    assertEquals(expected, actual)
}
