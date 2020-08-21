package com.github.dkoval.leetcode.interview.strings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ImplementStrStrTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "hello",
                "ll",
                2
            ),
            Arguments.of(
                "aaaaa",
                "bba",
                -1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the index of the first occurrence of needle in haystack`(
        haystack: String,
        needle: String,
        expected: Int
    ) {
        val actual = ImplementStrStr.strStr(haystack, needle)
        assertEquals(expected, actual)
    }
}