package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SumOfDigitsOfStringAfterConvertTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("iiii", 1, 36),
            Arguments.of("leetcode", 2, 6),
            Arguments.of("zbax", 2, 8)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return sum of digits of string after k transformations`(s: String, k: Int, expected: Int) {
        val actual = SumOfDigitsOfStringAfterConvert().getLucky(s, k)
        assertEquals(expected, actual)
    }
}