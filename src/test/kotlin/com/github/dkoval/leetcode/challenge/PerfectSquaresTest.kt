package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PerfectSquaresTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(12, 3), // 12 = 4 + 4 + 4
            Arguments.of(13, 2), // 13 = 4 + 9
            Arguments.of(20, 2) // 20 = 4 + 16
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the least number of perfect square numbers which sum to n`(n: Int, expected: Int) {
        val actual = PerfectSquares.numSquares(n)
        assertEquals(expected, actual)
    }
}