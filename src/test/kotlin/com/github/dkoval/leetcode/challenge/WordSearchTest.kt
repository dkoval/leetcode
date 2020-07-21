package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class WordSearchTest {

    companion object {

        private val board1 = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E')
        )

        private val board2 = arrayOf(
            charArrayOf('C', 'A', 'A'),
            charArrayOf('A', 'A', 'A'),
            charArrayOf('B', 'C', 'D')
        )

        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(board1, "ABCCED", true),
            Arguments.of(board1, "SEE", true),
            Arguments.of(board1, "ABCB", false),
            Arguments.of(board2, "AAB", true)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find if the word exists in the grid`(board: Array<CharArray>, word: String, expected: Boolean) {
        val actual = WordSearch.exist(board, word)
        assertEquals(expected, actual)
    }
}