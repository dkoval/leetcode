package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MinimumCostForTicketsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 4, 6, 7, 8, 20),
                intArrayOf(2, 7, 15),
                11
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the minimum number of dollars you need to travel every day in the given list of days`(
        days: IntArray,
        costs: IntArray,
        expected: Int
    ) {
        val actual = MinimumCostForTickets.mincostTickets(days, costs)
        assertEquals(expected, actual)
    }
}