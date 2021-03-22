package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class DivideTwoIntegersTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                10,
                3,
                3
            ),
            Arguments.of(
                7,
                -3,
                -2
            ),
            Arguments.of(
                0,
                1,
                0
            ),
            Arguments.of(
                1,
                1,
                1
            ),
            Arguments.of(
                2147483647,
                1,
                2147483647
            ),
            Arguments.of(
                -2147483648,
                -1,
                2147483647
            ),
            Arguments.of(
                -2147483648,
                1,
                -2147483648
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should divide two integers`(dividend: Int, divisor: Int, expected: Int) {
        val actual = DivideTwoIntegers().divide(dividend, divisor)
        assertEquals(expected, actual)
    }
}