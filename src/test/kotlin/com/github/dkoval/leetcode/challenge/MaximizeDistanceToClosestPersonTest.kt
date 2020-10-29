package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaximizeDistanceToClosestPersonTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 0, 0, 0, 1, 0, 1),
                // If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
                // If Alex sits in any other open seat, the closest person has distance 1.
                // Thus, the maximum distance to the closest person is 2.
                2
            ),
            Arguments.of(
                intArrayOf(1, 0, 0, 0),
                // If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
                // This is the maximum distance possible, so the answer is 3.
                3
            ),
            Arguments.of(
                intArrayOf(0, 1),
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return that maximum distance to the closest person`(seats: IntArray, expected: Int) {
        val actual = MaximizeDistanceToClosestPerson().maxDistToClosest(seats)
        assertEquals(expected, actual)
    }
}