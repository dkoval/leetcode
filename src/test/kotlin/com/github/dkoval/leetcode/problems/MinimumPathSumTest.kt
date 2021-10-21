package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MinimumPathSumTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 3, 1),
                    intArrayOf(1, 5, 1),
                    intArrayOf(4, 2, 1)
                ),
                7
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6)
                ),
                12
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `find a path from top left to bottom right, which minimizes the sum of all numbers along its path`(
        grid: Array<IntArray>,
        expected: Int
    ) {
        val actual = MinimumPathSum().minPathSum(grid)
        assertEquals(expected, actual)
    }
}