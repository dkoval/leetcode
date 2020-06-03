package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class TwoCitySchedulingTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(10, 20),
                    intArrayOf(30, 200),
                    intArrayOf(400, 50),
                    intArrayOf(30, 20)
                ),
                110
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the minimum cost to fly every person to a city such that exactly N people arrive in each city`(
        costs: Array<IntArray>,
        expected: Int
    ) {
        val actual = TwoCityScheduling.twoCitySchedCost(costs)
        assertEquals(expected, actual)
    }
}