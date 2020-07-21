package com.github.dkoval.leetcode.challenge

/**
 * [Word Search](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3397/)
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 */
object WordSearch {

    // Resource: https://www.youtube.com/watch?v=X0kX7PMOYi0&t=2s
    fun exist(board: Array<CharArray>, word: String): Boolean {
        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] == word[0] && existDFS(board, i, j, word, 0)) {
                    return true
                }
            }
        }
        return false
    }

    private fun existDFS(board: Array<CharArray>, i: Int, j: Int, word: String, idx: Int): Boolean {
        if (idx == word.lastIndex) {
            return true
        }

        val ch = board[i][j]
        if (ch == '#') {
            return false // already visited
        }

        board[i][j] = '#' // mark cell as visited
        val nextIdx = idx + 1
        val nextCh = word[nextIdx]
        if (i > 0 && board[i - 1][j] == nextCh && existDFS(board, i - 1, j, word, nextIdx) ||
            j > 0 && board[i][j - 1] == nextCh && existDFS(board, i, j - 1, word, nextIdx) ||
            i < board.lastIndex && board[i + 1][j] == nextCh && existDFS(board, i + 1, j, word, nextIdx) ||
            j < board[0].lastIndex && board[i][j + 1] == nextCh && existDFS(board, i, j + 1, word, nextIdx)
        ) {
            board[i][j] = ch // restore cell
            return true
        }

        board[i][j] = ch // restore cell
        return false
    }
}