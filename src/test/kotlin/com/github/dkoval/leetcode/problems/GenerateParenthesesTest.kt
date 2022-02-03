package com.github.dkoval.leetcode.problems

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class GenerateParenthesesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                1,
                listOf("()")
            ),
            Arguments.of(
                2,
                listOf("(())", "()()")
            ),
            Arguments.of(
                3,
                listOf("((()))", "(()())", "(())()", "()(())", "()()()")
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should generate all combinations of well-formed parentheses`(n: Int, expected: List<String>) {
        val actual = GenerateParentheses().generateParenthesis(n)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}