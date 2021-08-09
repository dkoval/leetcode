package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class AddStringsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "11",
                "123",
                "134"
            ),
            Arguments.of(
                "456",
                "77",
                "533"
            ),
            Arguments.of(
                "0",
                "0",
                "0"
            ),
            Arguments.of(
                "999",
                "1",
                "1000"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the sum of num1 and num2 as a string`(num1: String, num2: String, expected: String) {
        val actual = AddStrings().addStrings(num1, num2)
        assertEquals(expected, actual)
    }
}