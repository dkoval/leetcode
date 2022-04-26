package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MinCostToConnectAllPointsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(2, 2),
                    intArrayOf(3, 10),
                    intArrayOf(5, 2),
                    intArrayOf(7, 0)
                ),
                20
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 12),
                    intArrayOf(-2, 5),
                    intArrayOf(-4, 1)
                ),
                18
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the minimum cost to make all points connected`(points: Array<IntArray>, expected: Int) {
        val actual = MinCostToConnectAllPoints().minCostConnectPoints(points)
        assertEquals(expected, actual)
    }
}