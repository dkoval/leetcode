package com.github.dkoval.leetcode.interview.trees

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class WordLadderTest {
    private val solution = WordLadder()

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "hit",
                "cog",
                listOf("hot", "dot", "dog", "lot", "log", "cog"),
                5
            ),
            Arguments.of(
                "hit",
                "cog",
                listOf("hot", "dot", "dog", "lot", "log"),
                0
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>, expected: Int) {
        val actual = WordLadder().ladderLength(beginWord, endWord, wordList)
        assertEquals(expected, actual)
    }
}
