package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LongestPalindromeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            // One longest palindrome that can be built is "dccaccd", whose length is 7.
            Arguments.of(
                "abccccdd",
                7
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the length of the longest palindromes`(s: String, expected: Int) {
        val actual = LongestPalindrome.longestPalindrome(s)
        assertEquals(expected, actual)
    }
}