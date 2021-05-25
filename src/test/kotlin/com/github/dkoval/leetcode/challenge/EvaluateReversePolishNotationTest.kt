package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class EvaluateReversePolishNotationTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf("2", "1", "+", "3", "*"),
                9
            ),
            Arguments.of(
                arrayOf("4", "13", "5", "/", "+"),
                6
            ),
            Arguments.of(
                arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"),
                22
            ),
            Arguments.of(
                arrayOf("18"),
                18
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should evaluate the value of an arithmetic expression in Reverse Polish Notation`(
        tokens: Array<String>,
        expected: Int
    ) {
        val actual = EvaluateReversePolishNotation().evalRPN(tokens)
        assertEquals(expected, actual)
    }
}