package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumLengthOfRepeatedSubarray.MaximumLengthOfRepeatedSubarrayDPBottomUp
import com.github.dkoval.leetcode.challenge.MaximumLengthOfRepeatedSubarray.MaximumLengthOfRepeatedSubarrayWithOffset
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumLengthOfRepeatedSubarrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 2, 1),
                intArrayOf(3, 2, 1, 4, 7),
                // The repeated subarray with maximum length is [3,2,1]
                3
            ),
            Arguments.of(
                intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0),
                5
            ),
            Arguments.of(
                intArrayOf(0, 1, 1, 1, 1),
                intArrayOf(1, 0, 1, 0, 1),
                2
            )
        )
    }

    @Nested
    inner class MaximumLengthOfRepeatedSubarrayDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum length of a subarray that appears in both arrays`(
            nums1: IntArray,
            nums2: IntArray,
            expected: Int
        ) {
            MaximumLengthOfRepeatedSubarrayDPBottomUp().test(nums1, nums2, expected)
        }
    }

    @Nested
    inner class MaximumLengthOfRepeatedSubarrayWithOffsetTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum length of a subarray that appears in both arrays`(
            nums1: IntArray,
            nums2: IntArray,
            expected: Int
        ) {
            MaximumLengthOfRepeatedSubarrayWithOffset().test(nums1, nums2, expected)
        }
    }

    private fun MaximumLengthOfRepeatedSubarray.test(nums1: IntArray, nums2: IntArray, expected: Int) {
        val actual = findLength(nums1, nums2)
        assertEquals(expected, actual)
    }
}