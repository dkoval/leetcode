package com.github.dkoval.leetcode.interview.strings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class StringToIntegerTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("", 0),
            Arguments.of(" ", 0),
            Arguments.of("   ", 0),
            Arguments.of("42", 42),
            Arguments.of("   -42", -42),
            Arguments.of("4193 with words", 4193),
            Arguments.of("words and 987", 0),
            Arguments.of("-91283472332", Int.MIN_VALUE),
            Arguments.of("-2147483649", -2147483648)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should implement atoi which converts a string to an integer`(str: String, expected: Int) {
        val actual = StringToInteger.myAtoi(str)
        assertEquals(expected, actual)
    }
}