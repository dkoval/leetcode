package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaximumLengthOfRepeatedSubarrayTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
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
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the maximum length of a subarray that appears in both arrays`(
        nums1: IntArray,
        nums2: IntArray,
        expected: Int
    ) {
        val actual = MaximumLengthOfRepeatedSubarray().findLength(nums1, nums2)
        assertEquals(expected, actual)
    }
}