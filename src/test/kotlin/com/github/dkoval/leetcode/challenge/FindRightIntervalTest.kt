package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FindRightIntervalTest {


    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                ),
                intArrayOf(-1)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 4),
                    intArrayOf(2, 3),
                    intArrayOf(1, 2)
                ),
                intArrayOf(-1, 0, 1)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 4),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4)
                ),
                intArrayOf(-1, 2, -1)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the right interval`(intervals: Array<IntArray>, expected: IntArray) {
        val actual = FindRightInterval.findRightInterval(intervals)
        assertArrayEquals(expected, actual)
    }
}