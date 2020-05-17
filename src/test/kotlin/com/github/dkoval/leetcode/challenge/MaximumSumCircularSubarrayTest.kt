package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaximumSumCircularSubarrayTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(intArrayOf(1, -2, 3, -2), 3), // Subarray [3] has maximum sum 3
            Arguments.of(intArrayOf(5, -3, 5), 10),    // Subarray [5,5] has maximum sum 5 + 5 = 10
            Arguments.of(intArrayOf(3, -1, 2, -1), 4), // Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
            Arguments.of(intArrayOf(3, -2, 2, -3), 3), // Subarray [3] and [3,-2,2] both have maximum sum 3
            Arguments.of(intArrayOf(-2, -3, -1), -1),  // Subarray [-1] has maximum sum -1
            Arguments.of(intArrayOf(5, -3, -2, 6, -1, 4), 14)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find Maximum sum circular subarray`(nums: IntArray, expected: Int) {
        val actual = MaximumSumCircularSubarray.maxSubarraySumCircular(nums)
        assertEquals(expected, actual)
    }
}