package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindMaximumLengthOfValidSubsequence2.FindMaximumLengthOfValidSubsequence2Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindMaximumLengthOfValidSubsequence2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                2,
                5
            ),
            Arguments.of(
                intArrayOf(1, 4, 2, 3, 1, 4),
                3,
                4
            )
        )
    }

    @Nested
    inner class FindMaximumLengthOfValidSubsequence2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest valid subsequence of nums`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            FindMaximumLengthOfValidSubsequence2Rev1().test(nums, k, expected)
        }
    }
}

private fun FindMaximumLengthOfValidSubsequence2.test(nums: IntArray, k: Int, expected: Int) {
    val actual = maximumLength(nums, k)
    assertEquals(expected, actual)
}
