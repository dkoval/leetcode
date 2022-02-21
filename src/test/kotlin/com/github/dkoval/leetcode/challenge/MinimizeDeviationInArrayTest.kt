package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MinimizeDeviationInArrayTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                1
            ),
            Arguments.of(
                intArrayOf(4, 1, 5, 20, 3),
                3
            ),
            Arguments.of(
                intArrayOf(2, 10, 8),
                3
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the minimum deviation the array can have after performing some number of operations`(
        nums: IntArray,
        expected: Int
    ) {
        val actual = MinimizeDeviationInArray().minimumDeviation(nums)
        assertEquals(expected, actual)
    }
}