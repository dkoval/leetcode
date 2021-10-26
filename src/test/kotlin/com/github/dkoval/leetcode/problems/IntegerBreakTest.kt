package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class IntegerBreakTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(2, 1),
            Arguments.of(3, 2),
            Arguments.of(4, 4),
            Arguments.of(5, 6),
            Arguments.of(6, 9),
            Arguments.of(7, 12),
            Arguments.of(8, 18),
            Arguments.of(9, 27),
            Arguments.of(10, 36),
            Arguments.of(11, 54),
            Arguments.of(12, 81)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the maximum product you can get`(n: Int, expected: Int) {
        val actual = IntegerBreak().integerBreak(n)
        assertEquals(expected, actual)
    }
}