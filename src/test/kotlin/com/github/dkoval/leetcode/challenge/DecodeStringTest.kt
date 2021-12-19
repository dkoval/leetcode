package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class DecodeStringTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "3[a]2[bc]",
                "aaabcbc"
            ),
            Arguments.of(
                "3[a2[c]]",
                "accaccacc"
            ),
            Arguments.of(
                "2[abc]3[cd]ef",
                "abcabccdcdcdef"
            ),
            Arguments.of(
                "abc3[cd]xyz",
                "abccdcdcdxyz"
            ),
            Arguments.of(
                "3[z]2[2[y]pq4[2[jk]e1[f]]]ef",
                "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should decode string`(s: String, expected: String) {
        val actual = DecodeString().decodeString(s)
        assertEquals(expected, actual)
    }
}