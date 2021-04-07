package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class DetermineIfStringHalvesAreAlikeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("book", true),
            Arguments.of("textbook", false),
            Arguments.of("MerryChristmas", false),
            Arguments.of("AbCdEfGh", true)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should determine of string halves are alike`(s: String, expected: Boolean) {
        val actual = DetermineIfStringHalvesAreAlike().halvesAreAlike(s)
        assertEquals(expected, actual)
    }
}