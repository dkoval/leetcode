package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ArrangingCoinsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(1, 1),
            Arguments.of(5, 2),
            Arguments.of(8, 3),
            Arguments.of(1804289383, 60070)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the total number of full staircase rows that can be formed`(n: Int, expected: Int) {
        val actual = ArrangingCoins.arrangeCoins(n)
        assertEquals(expected, actual)
    }
}