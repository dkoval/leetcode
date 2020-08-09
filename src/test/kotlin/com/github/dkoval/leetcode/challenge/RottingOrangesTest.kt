package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RottingOrangesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 1, 1),
                    intArrayOf(1, 1, 0),
                    intArrayOf(0, 1, 1)
                ),
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 1, 1),
                    intArrayOf(0, 1, 1),
                    intArrayOf(1, 0, 1)
                ),
                -1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 2)
                ),
                0
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the minimum number of minutes that must elapse until no cell has a fresh orange`(
        grid: Array<IntArray>,
        expected: Int
    ) {
        val actual = RottingOranges.orangesRotting(grid)
        assertEquals(expected, actual)
    }
}