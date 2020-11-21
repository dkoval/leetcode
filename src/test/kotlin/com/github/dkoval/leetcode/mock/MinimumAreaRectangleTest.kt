package com.github.dkoval.leetcode.mock

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MinimumAreaRectangleTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 3),
                    intArrayOf(3, 1),
                    intArrayOf(3, 3),
                    intArrayOf(2, 2)
                ),
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 3),
                    intArrayOf(3, 1),
                    intArrayOf(3, 3),
                    intArrayOf(4, 1),
                    intArrayOf(4, 3)
                ),
                2
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should determine the minimum area of a rectangle formed from points, with sides parallel to the x and y axes`(
        points: Array<IntArray>,
        expected: Int
    ) {
        val actual = MinimumAreaRectangle().minAreaRect(points)
        assertEquals(expected, actual)
    }
}