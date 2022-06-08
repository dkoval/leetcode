package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RemovePalindromicSubsequencesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "ababa",
                1
            ),
            Arguments.of(
                "abb",
                2
            ),
            Arguments.of(
                "baabb",
                2
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should Return the minimum number of steps to make the given string empty`(s: String, expected: Int) {
        val actual = RemovePalindromicSubsequences().removePalindromeSub(s)
        assertEquals(expected, actual)
    }
}