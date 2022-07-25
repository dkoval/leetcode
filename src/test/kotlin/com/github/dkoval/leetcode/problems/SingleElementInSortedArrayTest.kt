package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.SingleElementInSortedArray.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SingleElementInSortedArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 1, 2, 3, 3, 4, 4, 8, 8),
                2
            ),
            Arguments.of(
                intArrayOf(3, 3, 7, 7, 10, 11, 11),
                10
            ),
            Arguments.of(
                intArrayOf(3, 3, 7, 7, 10, 10, 11),
                11
            ),
            Arguments.of(
                intArrayOf(42),
                42
            ),
            Arguments.of(
                intArrayOf(1, 1, 2, 3, 3),
                2
            )
        )
    }

    @Nested
    inner class SingleElementInSortedArrayInLinearTimeUsingXorOperatorTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the single element that appears only once`(nums: IntArray, expected: Int) {
            SingleElementInSortedArrayInLinearTimeUsingXorOperator().test(nums, expected)
        }
    }

    @Nested
    inner class SingleElementInSortedArrayInLinearTimeByMoving2StepsAtTimeTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the single element that appears only once`(nums: IntArray, expected: Int) {
            SingleElementInSortedArrayInLinearTimeByMoving2StepsAtTime().test(nums, expected)
        }
    }

    @Nested
    inner class SingleElementInSortedArrayUsingBinarySearchTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the single element that appears only once`(nums: IntArray, expected: Int) {
            SingleElementInSortedArrayUsingBinarySearch().test(nums, expected)
        }
    }

    private fun SingleElementInSortedArray.test(nums: IntArray, expected: Int) {
        val actual = singleNonDuplicate(nums)
        assertEquals(expected, actual)
    }
}