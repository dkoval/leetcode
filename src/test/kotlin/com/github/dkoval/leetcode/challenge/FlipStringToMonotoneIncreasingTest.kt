package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FlipStringToMonotoneIncreasingTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("00110", 1),
            Arguments.of("010110", 2),
            Arguments.of("010101011100011111", 6),
            Arguments.of("00011000", 2)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the minimum number of flips to make s monotone increasing`(s: String, expected: Int) {
        val actual = FlipStringToMonotoneIncreasing().minFlipsMonoIncr(s)
        assertEquals(expected, actual)
    }
}