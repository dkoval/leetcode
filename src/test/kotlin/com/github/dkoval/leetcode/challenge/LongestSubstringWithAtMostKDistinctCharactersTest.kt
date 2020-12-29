package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LongestSubstringWithAtMostKDistinctCharactersTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "eceba",
                2,
                3
            ),
            Arguments.of(
                "aa",
                1,
                2
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the length of the longest substring of s that contains at most k distinct characters`(
        s: String,
        k: Int,
        expected: Int
    ) {
        val actual = LongestSubstringWithAtMostKDistinctCharacters().lengthOfLongestSubstringKDistinct(s, k)
        assertEquals(expected, actual)
    }
}