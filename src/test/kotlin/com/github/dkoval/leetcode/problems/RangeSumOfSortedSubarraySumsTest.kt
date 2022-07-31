package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.RangeSumOfSortedSubarraySums.RangeSumOfSortedSubarraySumsNaive
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RangeSumOfSortedSubarraySumsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                4, 1, 5,
                13
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                4, 3, 4,
                6
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                4, 1, 10,
                50
            )
        )
    }

    @Nested
    inner class RangeSumOfSortedSubarraySumsNaiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the sum of the numbers from index left to index right`(
            nums: IntArray,
            n: Int,
            left: Int,
            right: Int,
            expected: Int
        ) {
            RangeSumOfSortedSubarraySumsNaive().test(nums, n, left, right, expected)
        }
    }

    private fun RangeSumOfSortedSubarraySums.test(nums: IntArray, n: Int, left: Int, right: Int, expected: Int) {
        val actual = rangeSum(nums, n, left, right)
        assertEquals(expected, actual)
    }
}