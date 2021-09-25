package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ShortestPathInGridWithObstaclesEliminationTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(1, 1, 0),
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 1),
                    intArrayOf(0, 0, 0)
                ),
                1,
                6
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1, 1),
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 0, 0)
                ),
                1,
                -1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0)
                ),
                1,
                0
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the minimum number of steps to walk from the upper left corner to the lower right corner given that you can eliminate at most k obstacles`(
        grid: Array<IntArray>,
        k: Int,
        expected: Int
    ) {
        val actual = ShortestPathInGridWithObstaclesElimination().shortestPath(grid, k)
        assertEquals(expected, actual)
    }
}