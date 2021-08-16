package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MinimumWindowSubstringTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "ADOBECODEBANC",
                "ABC",
                "BANC"
            ),
            Arguments.of(
                "a",
                "t",
                ""
            ),
            Arguments.of(
                "a",
                "aa",
                ""
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the minimum window substring of s such that every character in t (including duplicates) is included in the window`(
        s: String,
        t: String,
        expected: String
    ) {
        val actual = MinimumWindowSubstring().minWindow(s, t)
        assertEquals(expected, actual)
    }
}