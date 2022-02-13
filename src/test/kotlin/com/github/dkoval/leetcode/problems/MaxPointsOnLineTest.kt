package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaxPointsOnLineTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(2, 2),
                    intArrayOf(3, 3)
                ),
                3
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(3, 2),
                    intArrayOf(5, 3),
                    intArrayOf(4, 1),
                    intArrayOf(2, 3),
                    intArrayOf(1, 4)
                ),
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0)
                ),
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the maximum number of points that lie on the same straight line`(
        points: Array<IntArray>,
        expected: Int
    ) {
        val actual = MaxPointsOnLine().maxPoints(points)
        assertEquals(expected, actual)
    }
}