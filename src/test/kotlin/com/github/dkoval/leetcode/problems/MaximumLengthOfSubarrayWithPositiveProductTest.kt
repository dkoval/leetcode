package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaximumLengthOfSubarrayWithPositiveProductTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, -2, -3, 4),
                4
            ),
            Arguments.of(
                intArrayOf(0, 1, -2, -3, -4),
                3
            ),
            Arguments.of(
                intArrayOf(-1, -2, -3, 0, 1),
                2
            ),
            Arguments.of(
                intArrayOf(-1, 2),
                1
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 5, -6, 4, 0, 10),
                4
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the maximum length of a subarray with positive product`(nums: IntArray, expected: Int) {
        val actual = MaximumLengthOfSubarrayWithPositiveProduct().getMaxLen(nums)
        assertEquals(expected, actual)
    }
}