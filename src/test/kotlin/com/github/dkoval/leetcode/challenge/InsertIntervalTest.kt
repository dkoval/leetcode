package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class InsertIntervalTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(6, 9)
                ),
                intArrayOf(2, 5),
                arrayOf(
                    intArrayOf(1, 5),
                    intArrayOf(6, 9)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 5),
                    intArrayOf(6, 7),
                    intArrayOf(8, 10),
                    intArrayOf(12, 16)
                ),
                intArrayOf(4, 8),
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 10),
                    intArrayOf(12, 16)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 5),
                    intArrayOf(8, 10),
                    intArrayOf(12, 16)
                ),
                intArrayOf(6, 7),
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 5),
                    intArrayOf(6, 7),
                    intArrayOf(8, 10),
                    intArrayOf(12, 16)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 5),
                    intArrayOf(6, 7),
                    intArrayOf(8, 10),
                    intArrayOf(12, 16)
                ),
                intArrayOf(1, 2),
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 5),
                    intArrayOf(6, 7),
                    intArrayOf(8, 10),
                    intArrayOf(12, 16)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(6, 7),
                    intArrayOf(8, 10),
                    intArrayOf(12, 16)
                ),
                intArrayOf(3, 5),
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 5),
                    intArrayOf(6, 7),
                    intArrayOf(8, 10),
                    intArrayOf(12, 16)
                )
            ),
            Arguments.of(
                arrayOf<IntArray>(),
                intArrayOf(5, 7),
                arrayOf(
                    intArrayOf(5, 7)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 5)
                ),
                intArrayOf(6, 8),
                arrayOf(
                    intArrayOf(1, 5),
                    intArrayOf(6, 8)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should insert a new interval into into a set of non-overlapping intervals`(
        intervals: Array<IntArray>,
        newInterval: IntArray,
        expected: Array<IntArray>
    ) {
        val actual = InsertInterval.insert(intervals, newInterval)
        assertArrayEquals(expected, actual)
    }
}