package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class KokoEatingBananasTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(3, 6, 7, 11),
                8,
                4
            ),
            Arguments.of(
                intArrayOf(30, 11, 23, 4, 20),
                5,
                30
            ),
            Arguments.of(
                intArrayOf(30, 11, 23, 4, 20),
                6,
                23
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the minimum integer k such that she can eat all the bananas within h hours`(
        piles: IntArray,
        h: Int,
        expected: Int
    ) {
        val actual = KokoEatingBananas().minEatingSpeed(piles, h)
        assertEquals(expected, actual)
    }
}