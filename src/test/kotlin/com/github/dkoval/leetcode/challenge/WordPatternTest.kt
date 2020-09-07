package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class WordPatternTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "abba",
                "dog cat cat dog",
                true
            ),
            Arguments.of(
                "abba",
                "dog cat cat fish",
                false
            ),
            Arguments.of(
                "aaaa",
                "dog cat cat dog",
                false
            ),
            Arguments.of(
                "abba",
                "dog dog dog dog",
                false
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should check if a string follows the pattern`(pattern: String, str: String, expected: Boolean) {
        val actual = WordPattern.wordPattern(pattern, str)
        assertEquals(expected, actual)
    }
}