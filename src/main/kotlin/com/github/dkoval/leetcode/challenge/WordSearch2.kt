package com.github.dkoval.leetcode.challenge

/**
 * [Word Search II](https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/543/week-5-june-29th-june-30th/3376/)
 *
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 * horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 */
object WordSearch2 {

    private class TrieNode {
        val next: MutableMap<Char, TrieNode> = mutableMapOf()
        var word: String? = null
    }

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val root = buildTrie(words)
        val result = mutableListOf<String>()
        for (i in board.indices) {
            for (j in board[0].indices) {
                dfs(board, i, j, root, result)
            }
        }
        return result
    }

    private fun buildTrie(words: Array<String>): TrieNode =
        TrieNode().apply {
            for (word in words) {
                var curr = this
                for (ch in word) {
                    curr = curr.next.getOrPut(ch) { TrieNode() }
                }
                curr.word = word
            }
        }

    private fun dfs(board: Array<CharArray>, i: Int, j: Int, node: TrieNode, result: MutableList<String>) {
        if (i !in board.indices || j !in board[0].indices) return

        val ch = board[i][j]
        if (ch == '#') return // already visited
        val curr = node.next[ch] ?: return // candidate does not exist in all words' prefix, stop backtracking

        curr.word?.also {
            result.add(it)
            curr.word = null
        }

        board[i][j] = '#' // mark cell as visited
        dfs(board, i - 1, j, curr, result)  // go up
        dfs(board, i, j + 1, curr, result) // go right
        dfs(board, i + 1, j, curr, result) // go down
        dfs(board, i, j - 1, curr, result) // go left
        board[i][j] = ch // restore cell
    }
}