package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CombinationSum4Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 2, 3),
                4,
                // The possible combination ways are:
                // (1, 1, 1, 1)
                // (1, 1, 2)
                // (1, 2, 1)
                // (1, 3)
                // (2, 1, 1)
                // (2, 2)
                // (3, 1)
                7
            ),
            Arguments.of(
                intArrayOf(9),
                3,
                0
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the number of possible combinations that add up to target`(
        nums: IntArray,
        target: Int,
        expected: Int
    ) {
        val actual = CombinationSum4().combinationSum4(nums, target)
        assertEquals(expected, actual)
    }
}