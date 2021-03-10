package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class IntegerToRomanTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(3, "III"),
            Arguments.of(4, "IV"),
            Arguments.of(9, "IX"),
            Arguments.of(58, "LVIII"),
            Arguments.of(1994, "MCMXCIV")
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should convert an integer to to a roman numeral`(num: Int, expected: String) {
        val actual = IntegerToRoman().intToRoman(num)
        assertEquals(expected, actual)
    }
}