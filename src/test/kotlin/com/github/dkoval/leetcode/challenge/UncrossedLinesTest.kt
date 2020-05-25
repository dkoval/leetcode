package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class UncrossedLinesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 4, 2),
                intArrayOf(1, 2, 4),
                2
            ),
            Arguments.of(
                intArrayOf(2, 5, 1, 2, 5),
                intArrayOf(10, 5, 2, 1, 5, 2),
                3
            ),
            Arguments.of(
                intArrayOf(1, 3, 7, 1, 7, 5),
                intArrayOf(1, 9, 2, 5, 1),
                2
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the maximum number of uncrossed connecting lines`(A: IntArray, B: IntArray, expected: Int) {
        val actual = UncrossedLines.maxUncrossedLines(A, B)
        assertEquals(expected, actual)
    }
}