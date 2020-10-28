package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ValidParenthesesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("()", true),
            Arguments.of("()[]{}", true),
            Arguments.of("(]", false),
            Arguments.of("([)]", false),
            Arguments.of("{[]}", true)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should determine if the input string is valid`(s: String, expected: Boolean) {
        val actual = ValidParentheses().isValid(s)
        assertEquals(expected, actual)
    }
}