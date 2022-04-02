package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ValidPalindrome2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("aba", true),
            Arguments.of("abca", true),
            Arguments.of( "abc", false)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return true if the s can be palindrome after deleting at most one character from it`(
        s: String,
        expected: Boolean
    ) {
        val actual = ValidPalindrome2().validPalindrome(s)
        assertEquals(actual, expected)
    }
}