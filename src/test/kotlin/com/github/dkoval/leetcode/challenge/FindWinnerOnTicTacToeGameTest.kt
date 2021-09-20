package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FindWinnerOnTicTacToeGameTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(2, 0),
                    intArrayOf(1, 1),
                    intArrayOf(2, 1),
                    intArrayOf(2, 2)
                ),
                "A"
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(1, 1),
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 0),
                    intArrayOf(2, 0)
                ),
                "B"
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(1, 1),
                    intArrayOf(2, 0),
                    intArrayOf(1, 0),
                    intArrayOf(1, 2),
                    intArrayOf(2, 1),
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(2, 2)
                ),
                "Draw"
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(1, 1)
                ),
                "Pending"
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 0),
                    intArrayOf(1, 1),
                    intArrayOf(0, 2),
                    intArrayOf(2, 1),
                    intArrayOf(1, 2),
                    intArrayOf(1, 0),
                    intArrayOf(0, 0),
                    intArrayOf(0, 1)
                ),
                "B"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find winner on a tic tac toe game`(moves: Array<IntArray>, expected: String) {
        val actual = FindWinnerOnTicTacToeGame().tictactoe(moves)
        assertEquals(expected, actual)
    }
}