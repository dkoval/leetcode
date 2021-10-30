package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LongestDuplicateSubstringTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "banana",
                "ana"
            ),
            Arguments.of(
                "abcd",
                ""
            ),
            Arguments.of(
                "aa",
                "a"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return any duplicated substring that has the longest possible length`(s: String, expected: String) {
        val actual = LongestDuplicateSubstring().longestDupSubstring(s)
        assertEquals(expected, actual)
    }
}