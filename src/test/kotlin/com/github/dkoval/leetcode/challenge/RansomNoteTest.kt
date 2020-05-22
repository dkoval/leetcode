package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RansomNoteTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("a", "b", false),
            Arguments.of("aa", "ab", false),
            Arguments.of("aa", "aab", true)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should check if the ransom note can be constructed from the magazines`(
        ransomNote: String,
        magazine: String,
        expected: Boolean
    ) {
        val actual = RansomNote.canConstruct(ransomNote, magazine)
        assertEquals(expected, actual)
    }
}