package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ShiftingLettersTest {

    companion object {
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "abc",
                intArrayOf(3, 5, 9),
                "rpl"
            ),
            Arguments.of(
                "aaa",
                intArrayOf(1, 2, 3),
                "gfd"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `return the final string after all shifts to s are applied`(s: String, shifts: IntArray, expected: String) {
        val actual = ShiftingLetters().shiftingLetters(s, shifts)
        assertEquals(expected, actual)
    }
}