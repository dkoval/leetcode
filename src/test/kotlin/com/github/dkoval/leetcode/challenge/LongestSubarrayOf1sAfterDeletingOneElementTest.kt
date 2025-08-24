package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LongestSubarrayOf1sAfterDeletingOneElement.LongestSubarrayOf1sAfterDeletingOneElementRev1
import com.github.dkoval.leetcode.challenge.LongestSubarrayOf1sAfterDeletingOneElement.LongestSubarrayOf1sAfterDeletingOneElementRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LongestSubarrayOf1sAfterDeletingOneElementTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 1, 0, 1),
                3
            ),
            Arguments.of(
                intArrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1),
                5
            ),
            Arguments.of(
                intArrayOf(1, 1, 1),
                2
            ),
            Arguments.of(
                intArrayOf(0, 0),
                0
            ),
            Arguments.of(
                intArrayOf(0),
                0
            ),
            Arguments.of(
                intArrayOf(0, 1),
                1
            )
        )
    }

    @Nested
    inner class LongestSubarrayOf1sAfterDeletingOneElementRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the size of the longest non-empty subarray containing only 1's in the resulting array`(
            nums: IntArray,
            expected: Int
        ) {
            LongestSubarrayOf1sAfterDeletingOneElementRev1().test(nums, expected)
        }
    }

    @Nested
    inner class LongestSubarrayOf1sAfterDeletingOneElementRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the size of the longest non-empty subarray containing only 1's in the resulting array`(
            nums: IntArray,
            expected: Int
        ) {
            LongestSubarrayOf1sAfterDeletingOneElementRev2().test(nums, expected)
        }
    }
}

private fun LongestSubarrayOf1sAfterDeletingOneElement.test(nums: IntArray, expected: Int) {
    val actual = longestSubarray(nums)
    assertEquals(expected, actual)
}
