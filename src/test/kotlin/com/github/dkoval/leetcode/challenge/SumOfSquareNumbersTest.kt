package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SumOfSquareNumbersTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            // 1^2 + 2^2 = 5
            Arguments.of(5, true),
            // 2^2 + 2^2 = 4
            Arguments.of(4, true),
            // no solution
            Arguments.of(3, false),
            // 1^2 + 1^2 = 2
            Arguments.of(2, true),
            // 0^2 + 1^2 = 1
            Arguments.of(1, true),
            // 0^2 + 0^2 = 0
            Arguments.of(0, true),
            // no solution
            Arguments.of(Int.MAX_VALUE, false)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should decide whether there are two integers a and b such that a^2 + b^2 = c`(c: Int, expected: Boolean) {
        val actual = SumOfSquareNumbers().judgeSquareSum(c)
        assertEquals(expected, actual)
    }
}