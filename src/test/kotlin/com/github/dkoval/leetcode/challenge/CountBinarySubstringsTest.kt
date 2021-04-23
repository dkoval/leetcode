package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CountBinarySubstringsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "00110011",
                6
            ),
            Arguments.of(
                "10101",
                4
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should count the number of non-empty substrings that have the same number of 0's and 1's`(
        s: String,
        expected: Int
    ) {
        val actual = CountBinarySubstrings().countBinarySubstrings(s)
        assertEquals(expected, actual)
    }
}