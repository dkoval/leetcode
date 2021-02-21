package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RomanToIntegerTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("III", 3),
            Arguments.of("IV", 4),
            Arguments.of("IX", 9),
            Arguments.of("LVIII", 58),
            Arguments.of("MCMXCIV", 1994)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should convert a roman numeral to an integer`(s: String, expected: Int) {
        val actual = RomanToInteger().romanToInt(s)
        assertEquals(expected, actual)
    }
}