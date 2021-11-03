package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FindAllAnagramsInStringTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "cbaebabacd",
                "abc",
                listOf(0, 6)
            ),
            Arguments.of(
                "abab",
                "ab",
                listOf(0, 1, 2)
            ),
            Arguments.of(
                "ab",
                "bac",
                listOf<Int>()
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find all anagrams in a string`(s: String, p: String, expected: List<Int>) {
        val actual = FindAllAnagramsInString.findAnagrams(s, p)
        assertEquals(expected, actual)
    }
}