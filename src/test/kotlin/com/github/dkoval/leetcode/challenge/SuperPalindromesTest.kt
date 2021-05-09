package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SuperPalindromesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "4",
                "1000",
                4
            ),
            Arguments.of(
                "1",
                "2",
                1
            ),
            Arguments.of(
                "40000000000000000",
                "50000000000000000",
                2
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the number of super-palindromes integers in the inclusive range`(
        left: String,
        right: String,
        expected: Int
    ) {
        val actual = SuperPalindromes().superpalindromesInRange(left, right)
        assertEquals(expected, actual)
    }
}