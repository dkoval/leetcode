package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LargestTimeForGivenDigitsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                "23:41"
            ),
            Arguments.of(
                intArrayOf(3, 2, 4, 0),
                "23:40"
            ),
            Arguments.of(
                intArrayOf(6, 4, 0, 0),
                "06:40"
            ),
            Arguments.of(
                intArrayOf(6, 4, 5, 0),
                "06:54"
            ),
            Arguments.of(
                intArrayOf(6, 4, 5, 2),
                ""
            ),
            Arguments.of(
                intArrayOf(3, 2, 0, 0),
                "23:00"
            ),
            Arguments.of(
                intArrayOf(0, 0, 0, 0),
                "00:00"
            ),
            Arguments.of(
                intArrayOf(5, 5, 5, 5),
                ""
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the largest 24 hour time that can be made from array of 4 digits`(
        A: IntArray,
        expected: String
    ) {
        val actual = LargestTimeForGivenDigits.largestTimeFromDigits(A)
        assertEquals(expected, actual)
    }
}