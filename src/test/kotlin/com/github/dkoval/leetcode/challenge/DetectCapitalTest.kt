package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class DetectCapitalTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("USA", true),
            Arguments.of("leetcode", true),
            Arguments.of("Google", true),
            Arguments.of("FlaG", false)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should judge whether the usage of capitals in it is right or not`(word: String, expected: Boolean) {
        val actual = DetectCapital.detectCapitalUse(word)
        assertEquals(expected, actual)
    }
}