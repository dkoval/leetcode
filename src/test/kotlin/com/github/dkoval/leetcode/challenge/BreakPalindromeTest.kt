package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BreakPalindromeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "abccba",
                "aaccba"
            ),
            Arguments.of(
                "a",
                ""
            ),
            Arguments.of(
                "aa",
                "ab"
            ),
            Arguments.of(
                "aba",
                "abb"
            ),
            Arguments.of(
                "abba",
                "aaba"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should break a palindrome`(palindrome: String, expected: String) {
        val actual = BreakPalindrome().breakPalindrome(palindrome)
        assertEquals(expected, actual)
    }
}