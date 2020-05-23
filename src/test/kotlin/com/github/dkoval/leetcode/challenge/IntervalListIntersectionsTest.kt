package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class IntervalListIntersectionsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 2),
                    intArrayOf(5, 10),
                    intArrayOf(13, 23),
                    intArrayOf(24, 25)
                ),
                arrayOf(
                    intArrayOf(1, 5),
                    intArrayOf(8, 12),
                    intArrayOf(15, 24),
                    intArrayOf(25, 26)
                ),
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(5, 5),
                    intArrayOf(8, 10),
                    intArrayOf(15, 23),
                    intArrayOf(24, 24),
                    intArrayOf(25, 25)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 5)
                ),
                arrayOf(
                    intArrayOf(5, 7)
                ),
                arrayOf(intArrayOf(5, 5))
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(5, 7)
                ),
                arrayOf(
                    intArrayOf(1, 5)
                ),
                arrayOf(intArrayOf(5, 5))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the intersection of these two interval lists`(
        A: Array<IntArray>,
        B: Array<IntArray>,
        expected: Array<IntArray>
    ) {
        val actual = IntervalListIntersections.intervalIntersection(A, B)
        assertArrayEquals(expected, actual)
    }
}