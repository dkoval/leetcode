package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ReverseWordsInStringTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("the sky is blue", "blue is sky the"),
            Arguments.of("  hello world!  ", "world! hello"),
            Arguments.of("a good   example", "example good a")
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should reverse words in a String`(s: String, expected: String) {
        val actual = ReverseWordsInString.reverseWords(s)
        assertEquals(expected, actual)
    }
}