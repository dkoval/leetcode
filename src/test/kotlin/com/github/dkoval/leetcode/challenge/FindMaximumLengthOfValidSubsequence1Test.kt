package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindMaximumLengthOfValidSubsequence1.FindMaximumLengthOfValidSubsequence1Rev1
import com.github.dkoval.leetcode.challenge.FindMaximumLengthOfValidSubsequence1.FindMaximumLengthOfValidSubsequence1Rev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindMaximumLengthOfValidSubsequence1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                4
            ),
            Arguments.of(
                intArrayOf(1, 2, 1, 1, 2, 1, 2),
                6
            ),
            Arguments.of(
                intArrayOf(1, 3),
                2
            )
        )
    }

    @Nested
    inner class FindMaximumLengthOfValidSubsequence1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum length of a valid subsequence`(
            nums: IntArray,
            expected: Int
        ) {
            FindMaximumLengthOfValidSubsequence1Rev1().test(nums, expected)
        }
    }

    @Nested
    inner class FindMaximumLengthOfValidSubsequence1Rev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum length of a valid subsequence`(
            nums: IntArray,
            expected: Int
        ) {
            FindMaximumLengthOfValidSubsequence1Rev2().test(nums, expected)
        }
    }
}

private fun FindMaximumLengthOfValidSubsequence1.test(nums: IntArray, expected: Int) {
    val actual = maximumLength(nums)
    assertEquals(expected, actual)
}
