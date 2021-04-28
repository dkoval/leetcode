package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class UniquePaths2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 0)
                ),
                // There are two ways to reach the bottom-right corner:
                // 1. Right -> Right -> Down -> Down
                // 2. Down -> Down -> Right -> Right
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 0)
                ),
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the number of unique paths`(grid: Array<IntArray>, expected: Int) {
        val actual = UniquePaths2().uniquePathsWithObstacles(grid)
        assertEquals(expected, actual)
    }
}