package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ComplexNumberMultiplicationTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "1+1i",
                "1+1i",
                "0+2i"
            ),
            Arguments.of(
                "1+-1i",
                "1+-1i",
                "0+-2i"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should multiply two complex numbers`(num1: String, num2: String, expected: String) {
        val actual = ComplexNumberMultiplication().complexNumberMultiply(num1, num2)
        assertEquals(expected, actual)
    }
}