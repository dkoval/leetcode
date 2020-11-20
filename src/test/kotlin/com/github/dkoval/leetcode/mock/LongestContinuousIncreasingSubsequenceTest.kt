package com.github.dkoval.leetcode.mock

import com.github.dkoval.leetcode.mock.LongestContinuousIncreasingSubsequence.LongestContinuousIncreasingSubsequenceBruteForce
import com.github.dkoval.leetcode.mock.LongestContinuousIncreasingSubsequence.LongestContinuousIncreasingSubsequenceSlidingWindow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LongestContinuousIncreasingSubsequenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(),
                0
            ),
            Arguments.of(
                intArrayOf(1, 3, 5, 4, 7),
                3
            ),
            Arguments.of(
                intArrayOf(2, 2, 2, 2, 2),
                1
            )
        )
    }

    @Nested
    inner class LongestContinuousIncreasingSubsequenceBruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest continuous increasing subsequence`(nums: IntArray, expected: Int) {
            LongestContinuousIncreasingSubsequenceBruteForce().test(nums, expected)
        }
    }

    @Nested
    inner class LongestContinuousIncreasingSubsequenceSlidingWindowTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest continuous increasing subsequence`(nums: IntArray, expected: Int) {
            LongestContinuousIncreasingSubsequenceSlidingWindow().test(nums, expected)
        }
    }

    private fun LongestContinuousIncreasingSubsequence.test(nums: IntArray, expected: Int) {
        val actual = findLengthOfLCIS(nums)
        assertEquals(expected, actual)
    }
}