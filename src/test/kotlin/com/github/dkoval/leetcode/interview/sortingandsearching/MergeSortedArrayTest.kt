package com.github.dkoval.leetcode.interview.sortingandsearching

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MergeSortedArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 0, 0, 0),
                3,
                intArrayOf(2, 5, 6),
                3
            ),
            Arguments.of(
                intArrayOf(2, 5, 6, 0, 0, 0),
                3,
                intArrayOf(1, 2, 3),
                3
            ),
            Arguments.of(
                intArrayOf(2, 6, 8, 0, 0, 0, 0, 0),
                3,
                intArrayOf(1, 2, 3, 7, 9),
                5
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 7, 9, 0, 0, 0),
                5,
                intArrayOf(2, 6, 8),
                3
            )
        )
    }

    @Nested
    inner class MergeSortedArrayIntoLargerOneUsingExtraMSpaceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should merge nums2 into nums1 as one sorted array`(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
            MergeSortedArrayIntoLargerOneUsingExtraMSpace.test(nums1, m, nums2, n)
        }
    }

    @Nested
    inner class MergeSortedArrayIntoLargerOneUsingNoExtraSpaceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should merge nums2 into nums1 as one sorted array`(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
            MergeSortedArrayIntoLargerOneUsingNoExtraSpace.test(nums1, m, nums2, n)
        }
    }

    private fun MergeSortedArray.test(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        merge(nums1, m, nums2, n)
        assertThat(nums1).isSorted
    }
}