package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class StoneGameTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(5, 3, 4, 5),
                true
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should True if and only if the 1st player wins the game`(piles: IntArray, expected: Boolean) {
        val actual = StoneGame().stoneGame(piles)
        assertEquals(expected, actual)
    }
}