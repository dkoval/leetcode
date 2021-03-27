package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PalindromicSubstringsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "abc",
                // palindromic substrings: "a", "b", "c".
                3
            ),
            Arguments.of(
                "aaa",
                // palindromic substrings: "a", "a", "a", "aa", "aa", "aaa"
                6
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return number of palindromic substrings`(s: String, expected: Int) {
        val actual = PalindromicSubstrings().countSubstrings(s)
        assertEquals(expected, actual)
    }
}