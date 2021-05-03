package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RunningSumOf1dArrayTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(1, 3, 6, 10)
            ),
            Arguments.of(
                intArrayOf(1, 1, 1, 1, 1),
                intArrayOf(1, 2, 3, 4, 5)
            ),
            Arguments.of(
                intArrayOf(3, 1, 2, 10, 1),
                intArrayOf(3, 4, 6, 16, 17)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the running sum of nums`(nums: IntArray, expected: IntArray) {
        val actual = RunningSumOf1dArray().runningSum(nums)
        assertArrayEquals(expected, actual)
    }
}