package com.github.dkoval.leetcode.interview.strings

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ReverseStringTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                charArrayOf('h', 'e', 'l', 'l', 'o'),
                charArrayOf('o', 'l', 'l', 'e', 'h')
            ),
            Arguments.of(
                charArrayOf('H', 'a', 'n', 'n', 'a', 'h'),
                charArrayOf('h', 'a', 'n', 'n', 'a', 'H')
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should reverse string in-place`(s: CharArray, expected: CharArray) {
        ReverseString.reverseString(s)
        assertArrayEquals(expected, s)
    }
}