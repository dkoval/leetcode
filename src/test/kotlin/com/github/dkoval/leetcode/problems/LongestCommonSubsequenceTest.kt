package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LongestCommonSubsequenceTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("abcde", "ace", 3),
            Arguments.of("abc", "abc", 3),
            Arguments.of("abc", "def", 0),
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the length of their longest common subsequence`(text1: String, text2: String, expected: Int) {
        val actual = LongestCommonSubsequence().longestCommonSubsequence(text1, text2)
        assertEquals(expected, actual)
    }
}