package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class IsomorphicStringsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "egg",
                "add",
                true
            ),
            Arguments.of(
                "foo",
                "bar",
                false
            ),
            Arguments.of(
                "paper",
                "title",
                true
            ),
            Arguments.of(
                "abcd",
                "abae",
                false
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should determine of two strings are isomorphic`(s: String, t: String, expected: Boolean) {
        val actual = IsomorphicStrings().isIsomorphic(s, t)
        assertEquals(expected, actual)
    }
}