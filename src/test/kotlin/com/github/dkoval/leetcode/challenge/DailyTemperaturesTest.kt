package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class DailyTemperaturesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(73, 74, 75, 71, 69, 72, 76, 73),
                intArrayOf(1, 1, 4, 2, 1, 1, 0, 0)
            ),
            Arguments.of(
                intArrayOf(30, 40, 50, 60),
                intArrayOf(1, 1, 1, 0)
            ),
            Arguments.of(
                intArrayOf(30, 60, 90),
                intArrayOf(1, 1, 0)
            ),
            Arguments.of(
                intArrayOf(30),
                intArrayOf(0)
            ),
            Arguments.of(
                intArrayOf(40, 30),
                intArrayOf(0, 0)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return an array answer such that answer(i) is the number of days you have to wait after the ith day to get a warmer temperature`(
        temperatures: IntArray,
        expected: IntArray
    ) {
        val actual = DailyTemperatures().dailyTemperatures(temperatures)
        assertArrayEquals(expected, actual)
    }
}