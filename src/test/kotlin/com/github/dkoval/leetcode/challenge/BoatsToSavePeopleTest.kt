package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BoatsToSavePeopleTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 2),
                3,
                1
            ),
            Arguments.of(
                intArrayOf(3, 2, 2, 1),
                3,
                3
            ),
            Arguments.of(
                intArrayOf(3, 5, 3, 4),
                5,
                4
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `return the minimum number of boats to carry every given person`(people: IntArray, limit: Int, expected: Int) {
        val actual = BoatsToSavePeople().numRescueBoats(people, limit)
        assertEquals(expected, actual)
    }
}