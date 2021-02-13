package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ShortestPathInBinaryMatrixTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 0)
                ),
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(1, 1, 0),
                    intArrayOf(1, 1, 0)
                ),
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 0)
                ),
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 0),
                    intArrayOf(1, 1, 0),
                    intArrayOf(1, 1, 0)
                ),
                -1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the length of the shortest such clear path from top-left to bottom-right`(
        grid: Array<IntArray>,
        expected: Int
    ) {
        val actual = ShortestPathInBinaryMatrix().shortestPathBinaryMatrix(grid)
        assertEquals(expected, actual)
    }
}