package com.github.dkoval.leetcode.interview.array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LongestSubstringWithoutRepeatingCharactersTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "abcabcbb",
                3
            ),
            Arguments.of(
                "bbbbb",
                1
            ),
            Arguments.of(
                "pwwkew",
                3
            ),
            Arguments.of(
                "",
                0
            ),
            Arguments.of(
                " ",
                1
            ),
            Arguments.of(
                "tmmzuxt",
                5
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the length of the longest substring without repeating characters`(s: String, expected: Int) {
        val actual = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s)
        assertEquals(expected, actual)
    }
}