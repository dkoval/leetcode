package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class NumberOfSubarraysWithBoundedMaximumTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(2, 1, 4, 3),
                2,
                3,
                3
            ),
            Arguments.of(
                intArrayOf(2, 1, 4, 3, 3, 3, 4, 2, 1, 1, 2, 4, 2),
                2,
                3,
                16
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the number of subarrays such that the value of the maximum array element in that subarray is at least left and at most right`(
        nums: IntArray,
        left: Int,
        right: Int,
        expected: Int
    ) {
        val actual = NumberOfSubarraysWithBoundedMaximum().numSubarrayBoundedMax(nums, left, right)
        assertEquals(expected, actual)
    }
}