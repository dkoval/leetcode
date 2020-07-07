package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class IslandPerimeterTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1)
                ),
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1, 0, 0),
                    intArrayOf(1, 1, 1, 0),
                    intArrayOf(0, 1, 0, 0),
                    intArrayOf(1, 1, 0, 0)
                ),
                16
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 1)
                ),
                8
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should determine the perimeter of the island`(grid: Array<IntArray>, expected: Int) {
        val actual = IslandPerimeter.islandPerimeter(grid)
        assertEquals(expected, actual)
    }
}