package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ScoreOfParenthesesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "()",
                1
            ),
            Arguments.of(
                "(())",
                2
            ),
            Arguments.of(
                "()()",
                2
            ),
            Arguments.of(
                "(()(()))",
                6
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should score of parentheses`(S: String, expected: Int) {
        val actual = ScoreOfParentheses().scoreOfParentheses(S)
        assertEquals(expected, actual)
    }
}