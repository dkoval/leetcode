package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ExcelSheetColumnTitleTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(1, "A"),
            Arguments.of(2, "B"),
            Arguments.of(3, "C"),
            Arguments.of(26, "Z"),
            Arguments.of(28, "AB"),
            Arguments.of(701, "ZY")
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should column title as appear in an Excel sheet`(n: Int, expected: String) {
        val actual = ExcelSheetColumnTitle.convertToTitle(n)
        assertEquals(expected, actual)
    }
}