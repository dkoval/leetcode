package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LongestIncreasingSubsequence.LongestIncreasingSubsequenceDpBottomUp
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LongestIncreasingSubsequenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(10, 9, 2, 5, 3, 7, 101, 18),
                4
            ),
            Arguments.of(
                intArrayOf(0, 1, 0, 3, 2, 3),
                4
            ),
            Arguments.of(
                intArrayOf(7, 7, 7, 7, 7, 7, 7),
                1
            )
        )
    }

    @Nested
    inner class LongestIncreasingSubsequenceDpBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest strictly increasing subsequence`(nums: IntArray, expected: Int) {
            LongestIncreasingSubsequenceDpBottomUp().test(nums, expected)
        }
    }

    private fun LongestIncreasingSubsequence.test(nums: IntArray, expected: Int) {
        val actual = lengthOfLIS(nums)
        assertEquals(expected, actual)
    }
}