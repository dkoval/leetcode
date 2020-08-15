package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class NonOverlappingIntervalsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4),
                    intArrayOf(1, 3)
                ),
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the minimum number of intervals to remove to make the rest of the intervals non-overlapping`(
        intervals: Array<IntArray>,
        expected: Int
    ) {
        val actual = NonOverlappingIntervals.eraseOverlapIntervals(intervals)
        assertEquals(expected, actual)
    }
}