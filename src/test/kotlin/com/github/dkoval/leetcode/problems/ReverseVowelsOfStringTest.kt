package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ReverseVowelsOfStringTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "hello",
                "holle"
            ),
            Arguments.of(
                "leetcode",
                "leotcede"
            ),
            Arguments.of(
                "aA",
                "Aa"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should  reverse only all the vowels in the string and return it`(s: String, expected: String) {
        val actual = ReverseVowelsOfString().reverseVowels(s)
        assertEquals(expected, actual)
    }
}