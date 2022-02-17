package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SlidingPuzzleTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 0, 5)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(4, 1, 2),
                    intArrayOf(5, 0, 3)
                ),
                5
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(5, 4, 0)
                ),
                -1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 2, 3),
                    intArrayOf(5, 4, 1)
                ),
                -1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should  return the least number of moves required so that the state of the board is solved`(
        board: Array<IntArray>,
        expected: Int
    ) {
        val actual = SlidingPuzzle().slidingPuzzle(board)
        assertEquals(expected, actual)
    }
}