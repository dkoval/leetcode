package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.FindSmallestDivisorGivenThreshold.FindSmallestDivisorGivenThresholdUsingBinarySearch
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindSmallestDivisorGivenThresholdTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 5, 9),
                6,
                5
            ),
            Arguments.of(
                intArrayOf(44, 22, 33, 11, 1),
                5,
                44
            )
        )
    }

    @Nested
    inner class FindSmallestDivisorGivenThresholdUsingBinarySearchTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the smallest divisor such that the result mentioned above is less than or equal to threshold`(
            nums: IntArray,
            threshold: Int,
            expected: Int
        ) {
            FindSmallestDivisorGivenThresholdUsingBinarySearch().test(nums, threshold, expected)
        }
    }

    private fun FindSmallestDivisorGivenThreshold.test(nums: IntArray, threshold: Int, expected: Int) {
        val actual = smallestDivisor(nums, threshold)
        assertEquals(expected, actual)
    }
}