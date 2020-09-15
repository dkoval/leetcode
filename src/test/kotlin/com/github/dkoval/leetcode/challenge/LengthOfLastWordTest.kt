package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LengthOfLastWordTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "Hello World",
                5
            ),
            Arguments.of(
                "Hello World  ",
                5
            ),
            Arguments.of(
                "a",
                1
            ),
            Arguments.of(
                "a ",
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the length of last word`(s: String, expected: Int) {
        val actual = LengthOfLastWord.lengthOfLastWord(s)
        assertEquals(expected, actual)
    }
}