package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SurroundedRegionsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    charArrayOf('X', 'X', 'X', 'X'),
                    charArrayOf('X', 'O', 'O', 'X'),
                    charArrayOf('X', 'X', 'O', 'X'),
                    charArrayOf('X', 'O', 'X', 'X')
                ),
                arrayOf(
                    charArrayOf('X', 'X', 'X', 'X'),
                    charArrayOf('X', 'X', 'X', 'X'),
                    charArrayOf('X', 'X', 'X', 'X'),
                    charArrayOf('X', 'O', 'X', 'X')
                )
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('O', 'X', 'X', 'O'),
                    charArrayOf('X', 'O', 'O', 'X'),
                    charArrayOf('O', 'X', 'O', 'X'),
                    charArrayOf('X', 'O', 'X', 'O')
                ),
                arrayOf(
                    charArrayOf('O', 'X', 'X', 'O'),
                    charArrayOf('X', 'X', 'X', 'X'),
                    charArrayOf('O', 'X', 'X', 'X'),
                    charArrayOf('X', 'O', 'X', 'O')
                )
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('X', 'X', 'X', 'O'),
                    charArrayOf('X', 'O', 'O', 'X'),
                    charArrayOf('O', 'X', 'O', 'X'),
                    charArrayOf('X', 'O', 'O', 'X')
                ),
                arrayOf(
                    charArrayOf('X', 'X', 'X', 'O'),
                    charArrayOf('X', 'O', 'O', 'X'),
                    charArrayOf('O', 'X', 'O', 'X'),
                    charArrayOf('X', 'O', 'O', 'X')
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should capture all regions surrounded by X`(board: Array<CharArray>, expected: Array<CharArray>) {
        SurroundedRegions.solve(board)
        assertArrayEquals(expected, board)
    }
}