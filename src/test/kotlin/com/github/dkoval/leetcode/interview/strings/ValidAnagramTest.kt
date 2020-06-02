package com.github.dkoval.leetcode.interview.strings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ValidAnagramTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("anagram", "nagaram", true),
            Arguments.of("rat", "car", false)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should check if two strings are anagrams of each other`(s: String, t: String, expected: Boolean) {
        val actual = ValidAnagram.isAnagram(s, t)
        assertEquals(expected, actual)
    }
}