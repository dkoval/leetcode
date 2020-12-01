package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ShortestWordDistanceTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf("practice", "makes", "perfect", "coding", "makes"),
                "coding",
                "practice",
                3
            ),
            Arguments.of(
                arrayOf("practice", "makes", "perfect", "coding", "makes"),
                "makes",
                "coding",
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `return the shortest distance between these two words in the list`(
        words: Array<String>,
        word1: String,
        word2: String,
        expected: Int
    ) {
        val actual = ShortestWordDistance().shortestDistance(words, word1, word2)
        assertEquals(expected, actual)
    }
}