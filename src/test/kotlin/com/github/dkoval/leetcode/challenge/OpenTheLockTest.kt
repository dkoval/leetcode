package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class OpenTheLockTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf("0201", "0101", "0102", "1212", "2002"),
                "0202",
                6
            ),
            Arguments.of(
                arrayOf("8888"),
                "0009",
                1
            ),
            Arguments.of(
                arrayOf("8887","8889","8878","8898","8788","8988","7888","9888"),
                "8888",
                -1
            ),
            Arguments.of(
                arrayOf("0000"),
                "8888",
                -1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the minimum total number of turns required to open the lock, or -1 if it is impossible`(
        deadends: Array<String>,
        target: String,
        expected: Int
    ) {
        val actual = OpenTheLock().openLock(deadends, target)
        assertEquals(expected, actual)
    }
}