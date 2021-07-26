package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class WordLadder2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "hit",
                "cog",
                listOf("hot", "dot", "dog", "lot", "log", "cog"),
                listOf(
                    listOf("hit", "hot", "dot", "dog", "cog"),
                    listOf("hit", "hot", "lot", "log", "cog")
                )
            ),
            Arguments.of(
                "hit",
                "cog",
                listOf("hot", "dot", "dog", "lot", "log"),
                listOf<List<String>>()
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return all the shortest transformation sequences from beginWord to endWord`(
        beginWord: String,
        endWord: String,
        wordList: List<String>,
        expected: List<List<String>>
    ) {
        val actual = WordLadder2().findLadders(beginWord, endWord, wordList)
        println(actual)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}