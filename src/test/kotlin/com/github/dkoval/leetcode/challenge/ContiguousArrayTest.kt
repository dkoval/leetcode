package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ContiguousArrayTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(0, 1),
                2
            ),
            Arguments.of(
                intArrayOf(0, 1, 0),
                2
            ),
            Arguments.of(
                intArrayOf(0, 1, 0, 0, 1, 1, 0),
                6
            ),
            Arguments.of(
                intArrayOf(0, 0, 1, 0, 0, 0, 1, 1),
                6
            ),
            Arguments.of(
                intArrayOf(0, 1, 1, 0, 1, 1, 1, 0),
                4
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the maximum length of a contiguous subarray with equal number of 0 and 1`(
        nums: IntArray,
        expected: Int
    ) {
        val actual = ContiguousArray.findMaxLength(nums)
        assertEquals(expected, actual)
    }
}