package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ShortEncodingOfWordsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf("time", "me", "bell"),
                10
            ),
            Arguments.of(
                arrayOf("t"),
                2
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the length of the shortest reference string s possible of any valid encoding of words`(
        words: Array<String>,
        expected: Int
    ) {
        val actual = ShortEncodingOfWords().minimumLengthEncoding(words)
        assertEquals(expected, actual)
    }
}