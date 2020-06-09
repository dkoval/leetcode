package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class IsSubsequenceTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("abc", "ahbgdc", true),
            Arguments.of("axc", "ahbgdc", false)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should check if s is subsequence of t`(s: String, t: String, expected: Boolean) {
        val actual = IsSubsequence.isSubsequence(s, t)
        assertEquals(expected, actual)
    }
}