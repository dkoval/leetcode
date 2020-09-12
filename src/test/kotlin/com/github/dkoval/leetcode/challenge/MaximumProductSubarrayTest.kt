package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaximumProductSubarrayTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(2, 3, -2, 4),
                6 // [2,3] has the largest product 6
            ),
            Arguments.of(
                intArrayOf(-2, 0, -1),
                0 // The result cannot be 2, because [-2,-1] is not a subarray
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the contiguous subarray within an array (containing at least one number) which has the largest product`(
        nums: IntArray,
        expected: Int
    ) {
        val actual = MaximumProductSubarray.maxProduct(nums)
        assertEquals(expected, actual)
    }
}