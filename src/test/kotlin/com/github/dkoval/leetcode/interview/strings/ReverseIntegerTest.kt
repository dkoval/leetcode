package com.github.dkoval.leetcode.interview.strings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ReverseIntegerTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(123, 321),
            Arguments.of(-123, -321),
            Arguments.of(120, 21),
            Arguments.of(-120, -21),
            Arguments.of(0, 0),
            Arguments.of(1, 1),
            Arguments.of(100, 1),
            Arguments.of(-100, -1),
            // overflow scenarios
            Arguments.of(1534236469, 0),
            Arguments.of(1563847412, 0),
            Arguments.of(-2147483648, 0)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should reverse a 32-bit signed integer`(x: Int, expected: Int) {
        val actual = ReverseInteger.reverse(x)
        assertEquals(expected, actual)
    }
}