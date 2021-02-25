package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ShortestUnsortedContinuousSubarray.ShortestUnsortedContinuousSubarrayNaive
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ShortestUnsortedContinuousSubarrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 6, 4, 8, 10, 9, 15),
                // You need to sort [6, 4, 8, 10, 9] in asc order to make the whole array sorted in asc order
                5
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                0
            ),
            Arguments.of(
                intArrayOf(),
                0
            )
        )
    }

    @Nested
    inner class ShortestUnsortedContinuousSubarrayNaiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the shortest subarray such that if you only sort this subarray in asc order, then the whole array will be sorted in asc order`(
            nums: IntArray,
            expected: Int
        ) {
            ShortestUnsortedContinuousSubarrayNaive().test(nums, expected)
        }
    }

    private fun ShortestUnsortedContinuousSubarray.test(nums: IntArray, expected: Int) {
        val actual = findUnsortedSubarray(nums)
        assertEquals(expected, actual)
    }
}