package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LongestWordInDictionaryThroughDeletingTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "abpcplea",
                listOf("ale", "apple", "monkey", "plea"),
                "apple"
            ),
            Arguments.of(
                "abpcplea",
                listOf("a", "b", "c"),
                "a"
            ),
            Arguments.of(
                "bab",
                listOf("ba", "ab", "a", "b"),
                "ab"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the longest string in the dictionary that can be formed by deleting some characters of the given string`(
        s: String,
        d: List<String>,
        expected: String
    ) {
        val actual = LongestWordInDictionaryThroughDeleting().findLongestWord(s, d)
        assertEquals(expected, actual)
    }
}