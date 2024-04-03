package com.github.dkoval.leetcode.challenge

object WordSearchRev1 : WordSearch {

    private val directions = arrayOf(
        intArrayOf(-1, 0),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(0, 1)
    )

    // Resource: https://www.youtube.com/watch?v=X0kX7PMOYi0&t=2s
    override fun exist(board: Array<CharArray>, word: String): Boolean {
        for (row in board.indices) {
            for (col in board[0].indices) {
                if (board[row][col] == word[0] && existDFS(board, row, col, word, 0)) {
                    return true
                }
            }
        }
        return false
    }

    private fun existDFS(board: Array<CharArray>, row: Int, col: Int, word: String, idx: Int): Boolean {
        // base case
        if (idx == word.length) {
            return true
        }

        // boundary check
        val m = board.size
        val n = board[0].size
        if (row !in 0 until m || col !in 0 until n) {
            return false
        }

        if (board[row][col] != word[idx]) {
            return false
        }

        // mark cell as visited
        val c = board[row][col]
        board[row][col] = '#'

        // explore 4 adjacent directions
        for ((dx, dy) in directions) {
            if (existDFS(board, row + dx, col + dy, word, idx + 1)) {
                // restore cell
                board[row][col] = c
                return true
            }
        }

        // restore cell
        board[row][col] = c
        return false
    }
}