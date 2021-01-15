package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MinimumOperationsToReduceXToZeroTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 1, 4, 2, 3),
                5,
                2
            ),
            Arguments.of(
                intArrayOf(5, 6, 7, 8, 9),
                4,
                -1
            ),
            Arguments.of(
                intArrayOf(3, 2, 20, 1, 1, 3),
                10,
                5
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `return the minimum number of operations to reduce x to exactly 0`(nums: IntArray, x: Int, expected: Int) {
        val actual = MinimumOperationsToReduceXToZero().minOperations(nums, x)
        assertEquals(expected, actual)
    }
}