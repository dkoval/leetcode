package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MedianOfTwoSortedArrays.MedianOfTwoSortedArraysRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MedianOfTwoSortedArraysTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3),
                intArrayOf(2),
                2.00000
            ),
            Arguments.of(
                intArrayOf(1, 2),
                intArrayOf(3, 4),
                2.50000
            )
        )
    }

    @Nested
    inner class MedianOfTwoSortedArraysRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the median of the two sorted arrays`(nums1: IntArray, nums2: IntArray, expected: Double) {
            MedianOfTwoSortedArraysRev1().test(nums1, nums2, expected)
        }
    }
}

private fun MedianOfTwoSortedArrays.test(nums1: IntArray, nums2: IntArray, expected: Double) {
    val actual = findMedianSortedArrays(nums1, nums2)
    assertEquals(expected, actual, 1e-5)
}
