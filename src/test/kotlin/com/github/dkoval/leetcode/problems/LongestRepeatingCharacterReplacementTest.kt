package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LongestRepeatingCharacterReplacementTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("ABAB", 2, 4),
            Arguments.of( "AABABBA", 1, 4)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the length of the longest substring containing the same letter you can get`(
        s: String,
        k: Int,
        expected: Int
    ) {
        val actual = LongestRepeatingCharacterReplacement().characterReplacement(s, k)
        assertEquals(expected, actual)
    }
}