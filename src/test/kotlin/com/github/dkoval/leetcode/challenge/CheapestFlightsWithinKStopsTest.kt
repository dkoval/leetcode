package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CheapestFlightsWithinKStopsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(0, 1, 100),
                    intArrayOf(1, 2, 100),
                    intArrayOf(0, 2, 500)
                ),
                0,
                2,
                1,
                200
            ),
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(0, 1, 100),
                    intArrayOf(1, 2, 100),
                    intArrayOf(0, 2, 500)
                ),
                0,
                2,
                0,
                500
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the cheapest price from src to dst with up to k stops`(
        n: Int,
        flights: Array<IntArray>,
        src: Int,
        dst: Int,
        K: Int,
        expected: Int
    ) {
        val actual = CheapestFlightsWithinKStops.findCheapestPrice(n, flights, src, dst, K)
        assertEquals(expected, actual)
    }
}