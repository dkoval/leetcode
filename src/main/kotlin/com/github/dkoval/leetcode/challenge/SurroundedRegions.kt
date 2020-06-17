package com.github.dkoval.leetcode.challenge

/**
 * [Surrounded Regions](https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3363/)
 *
 * Given a 2D board containing 'X' and 'O' (the letter O)(the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
object SurroundedRegions {

    fun solve(board: Array<CharArray>) {
        // if number of rows/columns is [0:2], do nothing
        if (board.size <= 2 || board[0].size <= 2) {
            return
        }
        // mark 'O' cells connected to the 'O' cells on the borders
        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] == 'O' && board.cellIsOnBorder(i, j)) {
                    dfs(board, i, j)
                }
            }
        }
        // convert the board
        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'
                }
                if (board[i][j] == '$') {
                    board[i][j] = 'O'
                }
            }
        }
    }

    private fun dfs(board: Array<CharArray>, i: Int, j: Int) {
        if (board.cellIsWithinBounds(i, j) && board[i][j] == 'O') {
            board[i][j] = '$' // replace 'O' with an alternative character
            dfs(board, i - 1, j) // go ↑
            dfs(board, i, j + 1) // go →
            dfs(board, i + 1, j) // go ↓
            dfs(board, i, j - 1) // go ←
        }
    }

    private fun Array<CharArray>.cellIsOnBorder(i: Int, j: Int): Boolean =
        i == 0 || i == this.lastIndex || j == 0 || j == this[0].lastIndex

    private fun Array<CharArray>.cellIsWithinBounds(i: Int, j: Int): Boolean =
        i in this.indices && j in this[0].indices
}