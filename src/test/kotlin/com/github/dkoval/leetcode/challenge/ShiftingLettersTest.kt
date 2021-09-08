package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ShiftingLettersTest {

    companion object {
        @JvmStatic
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
            ),
            Arguments.of(
                "ktmq",
                intArrayOf(10, 26, 8, 2),
                "edws"
            ),
            Arguments.of(
                "mkgfzkkuxownxvfvxasy",
                intArrayOf(
                    505870226,
                    437526072,
                    266740649,
                    224336793,
                    532917782,
                    311122363,
                    567754492,
                    595798950,
                    81520022,
                    684110326,
                    137742843,
                    275267355,
                    856903962,
                    148291585,
                    919054234,
                    467541837,
                    622939912,
                    116899933,
                    983296461,
                    536563513
                ),
                "wqqwlcjnkphhsyvrkdod"
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