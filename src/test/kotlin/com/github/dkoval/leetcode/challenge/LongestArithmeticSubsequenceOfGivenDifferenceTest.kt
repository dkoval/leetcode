package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LongestArithmeticSubsequenceOfGivenDifference.LongestArithmeticSubsequenceOfGivenDifferenceRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LongestArithmeticSubsequenceOfGivenDifferenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                1,
                4
            ),
            Arguments.of(
                intArrayOf(1, 3, 5, 7),
                1,
                1
            ),
            Arguments.of(
                intArrayOf(1, 5, 7, 8, 5, 3, 4, 2, 1),
                -2,
                4
            )
        )
    }

    @Nested
    inner class LongestArithmeticSubsequenceOfGivenDifferenceRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest arithmetic subsequence of given difference`(
            arr: IntArray,
            difference: Int,
            expected: Int
        ) {
            LongestArithmeticSubsequenceOfGivenDifferenceRev1().test(arr, difference, expected)
        }
    }
}

private fun LongestArithmeticSubsequenceOfGivenDifference.test(arr: IntArray, difference: Int, expected: Int) {
    val actual = longestSubsequence(arr, difference)
    assertEquals(expected, actual)
}
