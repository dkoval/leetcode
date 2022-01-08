package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CherryPickup2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 1, 1),
                    intArrayOf(2, 5, 1),
                    intArrayOf(1, 5, 5),
                    intArrayOf(2, 1, 1)
                ),
                24
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 0, 0, 0, 0, 1),
                    intArrayOf(2, 0, 0, 0, 0, 3, 0),
                    intArrayOf(2, 0, 9, 0, 0, 0, 0),
                    intArrayOf(0, 3, 0, 5, 4, 0, 0),
                    intArrayOf(1, 0, 2, 3, 0, 0, 6)
                ),
                28
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the maximum number of cherries collection using both robots`(
        grid: Array<IntArray>,
        expected: Int
    ) {
        val actual = CherryPickup2().cherryPickup(grid)
        assertEquals(expected, actual)
    }
}