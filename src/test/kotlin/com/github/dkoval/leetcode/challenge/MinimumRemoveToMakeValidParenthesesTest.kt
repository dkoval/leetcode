package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MinimumRemoveToMakeValidParenthesesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "lee(t(c)o)de)",
                "lee(t(c)o)de"
            ),
            Arguments.of(
                "a)b(c)d",
                "ab(c)d"
            ),
            Arguments.of(
                "))((",
                ""
            ),
            Arguments.of(
                "(a(b(c)d)",
                "a(b(c)d)"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should remove the minimum number of parentheses so that the resulting parentheses string is valid`(
        s: String,
        expected: String
    ) {
        val actual = MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid(s)
        assertEquals(expected, actual)
    }
}