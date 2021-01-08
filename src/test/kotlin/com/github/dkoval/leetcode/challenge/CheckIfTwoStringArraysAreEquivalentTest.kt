package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CheckIfTwoStringArraysAreEquivalentTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf("ab", "c"),
                arrayOf("a", "bc"),
                true
            ),
            Arguments.of(
                arrayOf("a", "cb"),
                arrayOf("ab", "c"),
                false
            ),
            Arguments.of(
                arrayOf("abc", "d", "defg"),
                arrayOf("abcddefg"),
                true
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should check if two string arrays are equivalent`(
        word1: Array<String>,
        word2: Array<String>,
        expected: Boolean
    ) {
        val actual = CheckIfTwoStringArraysAreEquivalent().arrayStringsAreEqual(word1, word2)
        assertEquals(expected, actual)
    }
}