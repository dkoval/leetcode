package com.github.dkoval.leetcode.interview.strings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ValidPalindromeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("A man, a plan, a canal: Panama", true),
            Arguments.of("race a car", false),
            Arguments.of("", true)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should check if given string is a palindrome, considering only alphanumeric characters and ignoring cases`(
        s: String,
        expected: Boolean
    ) {
        val actual = ValidPalindrome.isPalindrome(s)
        assertEquals(expected, actual)
    }
}