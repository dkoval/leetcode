package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MakingLargeIslandTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(0, 1)
                ),
                3
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 0)
                ),
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 1)
                ),
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(0, 0)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(0, 1, 1, 1, 1, 0, 0),
                    intArrayOf(0, 1, 0, 0, 1, 0, 0),
                    intArrayOf(1, 0, 1, 0, 1, 0, 0),
                    intArrayOf(0, 1, 0, 0, 1, 0, 0),
                    intArrayOf(0, 1, 0, 0, 1, 0, 0),
                    intArrayOf(0, 1, 1, 1, 1, 0, 0)
                ),
                18
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the size of the largest island in grid after changing ot most one 0 to 1`(
        grid: Array<IntArray>,
        expected: Int
    ) {
        val actual = MakingLargeIsland().largestIsland(grid)
        assertEquals(expected, actual)
    }
}