package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaximumPointsYouCanObtainFromCardsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5, 6, 1),
                3,
                12
            ),
            Arguments.of(
                intArrayOf(2, 2, 2),
                2,
                4
            ),
            Arguments.of(
                intArrayOf(9, 7, 7, 9, 7, 7, 9),
                7,
                55
            ),
            Arguments.of(
                intArrayOf(1, 1000, 1),
                1,
                1
            ),
            Arguments.of(
                intArrayOf(1, 79, 80, 1, 1, 1, 200, 1),
                3,
                202
            ),
            Arguments.of(
                intArrayOf(11, 49, 100, 20, 86, 29, 72),
                4,
                232
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the maximum score you can obtain`(cardPoints: IntArray, k: Int, expected: Int) {
        val actual = MaximumPointsYouCanObtainFromCards().maxScore(cardPoints, k)
        assertEquals(expected, actual)
    }
}