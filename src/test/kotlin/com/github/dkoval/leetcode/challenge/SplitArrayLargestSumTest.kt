package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SplitArrayLargestSum.SplitArrayLargestSumDPTopDown
import com.github.dkoval.leetcode.challenge.SplitArrayLargestSum.SplitArrayLargestSumUsingBinarySearch
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class SplitArrayLargestSumTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(7, 2, 5, 10, 8),
                2,
                18
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                2,
                9
            ),
            Arguments.of(
                intArrayOf(1, 4, 4),
                3,
                4
            ),
            Arguments.of(
                intArrayOf(2, 3, 1, 2, 4, 3),
                5,
                4
            )
        )
    }

    @Nested
    inner class SplitArrayLargestSumDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should minimize the largest sum among m non-empty continuous subarrays of nums`(
            nums: IntArray,
            m: Int,
            expected: Int
        ) {
            SplitArrayLargestSumDPTopDown().test(nums, m, expected)
        }
    }

    @Nested
    inner class SplitArrayLargestSumUsingBinarySearchTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should minimize the largest sum among m non-empty continuous subarrays of nums`(
            nums: IntArray,
            m: Int,
            expected: Int
        ) {
            SplitArrayLargestSumUsingBinarySearch().test(nums, m, expected)
        }
    }

    private fun SplitArrayLargestSum.test(nums: IntArray, m: Int, expected: Int) {
        val actual = splitArray(nums, m)
        assertEquals(expected, actual)
    }
}