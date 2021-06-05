package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaximumPerformanceOfTeamTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                6,
                intArrayOf(2, 10, 3, 1, 5, 8),
                intArrayOf(5, 4, 3, 9, 7, 2),
                2,
                60
            ),
            Arguments.of(
                6,
                intArrayOf(2, 10, 3, 1, 5, 8),
                intArrayOf(5, 4, 3, 9, 7, 2),
                3,
                68
            ),
            Arguments.of(
                6,
                intArrayOf(2, 10, 3, 1, 5, 8),
                intArrayOf(5, 4, 3, 9, 7, 2),
                4,
                72
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the maximum performance of a team of at most k engineers`(
        n: Int,
        speed: IntArray,
        efficiency: IntArray,
        k: Int,
        expected: Int
    ) {
        val actual = MaximumPerformanceOfTeam().maxPerformance(n, speed, efficiency, k)
        assertEquals(expected, actual)
    }
}