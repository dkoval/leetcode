package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class VerifyingAlienDictionaryTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf("hello", "leetcode"),
                "hlabcdefgijkmnopqrstuvwxyz",
                true
            ),
            Arguments.of(
                arrayOf("word", "world", "row"),
                "worldabcefghijkmnpqstuvxyz",
                false
            ),
            Arguments.of(
                arrayOf("apple", "app"),
                "abcdefghijklmnopqrstuvwxyz",
                false
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return true if and only if the given words are sorted lexicographically in alien language`(
        words: Array<String>,
        order: String,
        expected: Boolean
    ) {
        val actual = VerifyingAlienDictionary().isAlienSorted(words, order)
        assertEquals(expected, actual)
    }
}