package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RemoveAllAdjacentDuplicatesInString2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "abcd",
                2,
                "abcd"
            ),
            Arguments.of(
                "deeedbbcccbdaa",
                3,
                "aa"
            ),
            Arguments.of(
                "pbbcggttciiippooaais",
                2,
                "ps"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the final string after k duplicate removals have been made`(s: String, k: Int, expected: String) {
        val actual = RemoveAllAdjacentDuplicatesInString2().removeDuplicates(s, k)
        assertEquals(expected, actual)
    }
}