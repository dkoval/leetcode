package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindSubsequenceOfLengthKWithTheLargestSum.FindSubsequenceOfLengthKWithTheLargestSumRev1
import com.github.dkoval.leetcode.challenge.FindSubsequenceOfLengthKWithTheLargestSum.FindSubsequenceOfLengthKWithTheLargestSumRev2
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindSubsequenceOfLengthKWithTheLargestSumTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 1, 3, 3),
                2,
                intArrayOf(3, 3)
            ),
            Arguments.of(
                intArrayOf(-1, -2, 3, 4),
                3,
                intArrayOf(-1, 3, 4)
            ),
            Arguments.of(
                intArrayOf(3, 4, 3, 3),
                2,
                intArrayOf(3, 4)
            )
        )
    }

    @Nested
    inner class FindSubsequenceOfLengthKWithTheLargestSumRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the subsequence of length k with the largest sum`(
            nums: IntArray,
            k: Int,
            expected: IntArray
        ) {
            FindSubsequenceOfLengthKWithTheLargestSumRev1().test(nums, k, expected)
        }
    }

    @Nested
    inner class FindSubsequenceOfLengthKWithTheLargestSumRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the subsequence of length k with the largest sum`(
            nums: IntArray,
            k: Int,
            expected: IntArray
        ) {
            FindSubsequenceOfLengthKWithTheLargestSumRev2().test(nums, k, expected)
        }
    }
}

private fun FindSubsequenceOfLengthKWithTheLargestSum.test(nums: IntArray, k: Int, expected: IntArray) {
    val actual = maxSubsequence(nums, k)
    assertArrayEquals(expected, actual)
}
