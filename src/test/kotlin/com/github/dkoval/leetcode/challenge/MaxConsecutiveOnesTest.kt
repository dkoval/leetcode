package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaxConsecutiveOnesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 1, 0, 1, 1, 1),
                3
            ),
            Arguments.of(
                intArrayOf(1, 0, 1, 1, 0, 1),
                2
            ),
            Arguments.of(
                intArrayOf(1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1),
                5
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the maximum number of consecutive 1's in the array`(nums: IntArray, expected: Int) {
        val actual = MaxConsecutiveOnes().findMaxConsecutiveOnes(nums)
        assertEquals(expected, actual)
    }
}