package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BasicCalculatorTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("1 + 1", 2),
            Arguments.of(" 2-1 + 2 ", 3),
            Arguments.of("(1+(4+5+2)-3)+(6+8)", 23),
            Arguments.of("- (3 + (4 + 5))", -12)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the result of the evaluation`(s: String, expected: Int) {
        val actual = BasicCalculator().calculate(s)
        assertEquals(expected, actual)
    }
}