package com.github.dkoval.leetcode.interview.recursion

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class WordSearch2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    charArrayOf('o', 'a', 'a', 'n'),
                    charArrayOf('e', 't', 'a', 'e'),
                    charArrayOf('i', 'h', 'k', 'r'),
                    charArrayOf('i', 'f', 'l', 'v'),
                ),
                arrayOf("oath", "pea", "eat", "rain"),
                listOf("eat","oath")
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('a', 'b'),
                    charArrayOf('c', 'd')
                ),
                arrayOf("abcb"),
                listOf<String>()
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return all words on the board`(board: Array<CharArray>, words: Array<String>, expected: List<String>) {
        val actual = WordSearch2().findWords(board, words)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}