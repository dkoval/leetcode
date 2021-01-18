package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaxNumberOfKSumPairsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                5,
                2
            ),
            Arguments.of(
                intArrayOf(3, 1, 3, 4, 3),
                6,
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the maximum number of operations you can perform on the array`(
        nums: IntArray,
        k: Int,
        expected: Int
    ) {
        val actual = MaxNumberOfKSumPairs().maxOperations(nums, k)
        assertEquals(expected, actual)
    }
}