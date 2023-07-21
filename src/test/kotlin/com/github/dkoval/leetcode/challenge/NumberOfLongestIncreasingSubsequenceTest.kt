package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfLongestIncreasingSubsequence.NumberOfLongestIncreasingSubsequenceRev1
import com.github.dkoval.leetcode.challenge.NumberOfLongestIncreasingSubsequence.NumberOfLongestIncreasingSubsequenceRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class NumberOfLongestIncreasingSubsequenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 5, 4, 7),
                // The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7]
                2
            ),
            Arguments.of(
                intArrayOf(2, 2, 2, 2, 2),
                // The length of the longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
                5
            )
        )
    }

    @Nested
    inner class NumberOfLongestIncreasingSubsequenceRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return return the number of longest increasing subsequences`(nums: IntArray, expected: Int) {
            NumberOfLongestIncreasingSubsequenceRev1().test(nums, expected)
        }
    }

    @Nested
    inner class NumberOfLongestIncreasingSubsequenceRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return return the number of longest increasing subsequences`(nums: IntArray, expected: Int) {
            NumberOfLongestIncreasingSubsequenceRev2().test(nums, expected)
        }
    }
}

private fun NumberOfLongestIncreasingSubsequence.test(nums: IntArray, expected: Int) {
    val actual = findNumberOfLIS(nums)
    assertEquals(expected, actual)
}
