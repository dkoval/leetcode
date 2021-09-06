package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SlowestKeyTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(9, 29, 49, 50),
                "cbcd",
                'c'
            ),
            Arguments.of(
                intArrayOf(12, 23, 36, 46, 62),
                "spuda",
                'a'
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the key of the keypress that had the longest duration`(
        releaseTimes: IntArray,
        keysPressed: String,
        expected: Char
    ) {
        val actual = SlowestKey().slowestKey(releaseTimes, keysPressed)
        assertEquals(expected, actual)
    }
}