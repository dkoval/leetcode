package com.github.dkoval.leetcode.interview.array

import java.util.*
import kotlin.math.sqrt

/**
 * [Valid Sudoku](https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/769/)
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * - Each row must contain the digits 1-9 without repetition.
 * - Each column must contain the digits 1-9 without repetition.
 * - Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
object ValidSudoku {

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        // check 9 row constraints
        for (i in board.indices) {
            if (hasDuplicate(
                    board,
                    i,
                    i + 1,
                    0,
                    board.size
                )
            ) {
                return false
            }
        }

        // check 9 column constraints
        for (j in board.indices) {
            if (hasDuplicate(
                    board,
                    0,
                    board.size,
                    j,
                    j + 1
                )
            ) {
                return false
            }
        }

        // check 9 sub-grid constrains
        val subGridSize = sqrt(board.size.toDouble()).toInt()
        for (i in 0 until subGridSize) {
            for (j in 0 until subGridSize) {
                if (hasDuplicate(
                        board,
                        i * subGridSize,
                        (i + 1) * subGridSize,
                        j * subGridSize,
                        (j + 1) * subGridSize
                    )
                ) {
                    return false
                }
            }
        }

        return true
    }

    private fun hasDuplicate(
        board: Array<CharArray>,
        startRow: Int,
        endRowExclusive: Int,
        startCol: Int,
        endColExclusive: Int
    ): Boolean {
        val alreadySeen = BitSet(board.size + 1)
        for (i in startRow until endRowExclusive) {
            for (j in startCol until endColExclusive) {
                if (board[i][j] != '.') {
                    val digit = board[i][j] - '0'
                    if (alreadySeen[digit]) {
                        return true
                    }
                    alreadySeen[digit] = true
                }
            }
        }
        return false
    }
}