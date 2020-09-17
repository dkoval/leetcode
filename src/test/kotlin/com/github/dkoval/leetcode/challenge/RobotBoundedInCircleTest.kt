package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RobotBoundedInCircleTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "GGLLGG",
                // The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
                // When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
                true
            ),
            Arguments.of(
                "GG",
                // The robot moves north indefinitely
                false
            ),
            Arguments.of(
                "GL",
                // The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
                true
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should check whether the robot is bounded`(instructions: String, expected: Boolean) {
        val actual = RobotBoundedInCircle.isRobotBounded(instructions)
        assertEquals(expected, actual)
    }
}