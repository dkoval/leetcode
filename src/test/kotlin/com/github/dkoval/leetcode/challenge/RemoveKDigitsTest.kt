package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RemoveKDigitsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("1432219", 3, "1219"),
            Arguments.of("10200", 1, "200"),
            Arguments.of("10", 2, "0"),
            Arguments.of("12345", 1, "1234"),
            Arguments.of("12145", 1, "1145"),
            Arguments.of("10354", 2, "34")
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should remove k digits from the number so that the new number is the smallest possible`(
        num: String,
        k: Int,
        expected: String
    ) {
        val actual = RemoveKDigits.removeKdigits(num, k)
        assertEquals(expected, actual)
    }
}