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

    val directions = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

    fun solve(board: Array<CharArray>) {
        val m = board.size
        val n = board[0].size

        // mark all 'O' cells connected to 'O' cells on borders - those cells form regions that can't be surrounded by 'X'
        for (col in 0 until n) {
            // 1st row
            if (board[0][col] == 'O') {
                dfs(board, 0, col)
            }
            // last row
            if (board[m - 1][col] == 'O') {
                dfs(board, m - 1, col)
            }
        }

        for (row in 0 until m) {
            // 1st column
            if (board[row][0] == 'O') {
                dfs(board, row, 0)
            }
            // last column
            if (board[row][n - 1] == 'O') {
                dfs(board, row, n - 1)
            }
        }

        // finally, turn 'O' -> 'X' - those cells form regions surrounded by 'X'
        for (row in 0 until m) {
            for (col in 0 until n) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X'
                }
                // cleanup visited cells
                if (board[row][col] == '#') {
                    board[row][col] = 'O'
                }
            }
        }
    }

    private fun dfs(board: Array<CharArray>, row: Int, col: Int) {
        if (board[row][col] != 'O') {
            return
        }

        // mark current cell as visited
        board[row][col] = '#'

        // run DFS for 4-directionally adjacent cells
        for ((dx, dy) in directions) {
            val nextRow = row + dx
            val nextCol = col + dy

            // boundaries check
            if (nextRow !in board.indices || nextCol !in board[0].indices) {
                continue
            }

            dfs(board, nextRow, nextCol)
        }
    }
}