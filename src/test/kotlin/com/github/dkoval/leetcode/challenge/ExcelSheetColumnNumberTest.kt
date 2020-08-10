package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ExcelSheetColumnNumberTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("A", 1),
            Arguments.of("Z", 26),
            Arguments.of("AA", 27),
            Arguments.of("AB", 28),
            Arguments.of("ZY", 701)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return a column number in an Excel sheet`(s: String, expected: Int) {
        val actual = ExcelSheetColumnNumber.titleToNumber(s)
        assertEquals(expected, actual)
    }
}