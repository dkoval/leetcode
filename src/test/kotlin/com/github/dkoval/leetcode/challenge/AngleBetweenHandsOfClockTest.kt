package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class AngleBetweenHandsOfClockTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(12, 30, 165.0),
            Arguments.of(3, 30, 75.0),
            Arguments.of(3, 15, 7.5),
            Arguments.of(4, 50, 155.0),
            Arguments.of(12, 0, 0.0),
            Arguments.of(11, 15, 112.5),
            Arguments.of(10, 25, 162.5),
            Arguments.of(9, 20, 160.0),
            Arguments.of(12, 10, 55.0)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the smaller angle (in degrees) formed between the hour and the minute hand`(
        hour: Int,
        minutes: Int,
        expected: Double
    ) {
        val actual = AngleBetweenHandsOfClock.angleClock(hour, minutes)
        assertEquals(expected, actual, 1e-6)
    }
}