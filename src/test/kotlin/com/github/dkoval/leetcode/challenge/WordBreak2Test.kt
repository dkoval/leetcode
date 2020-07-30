package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class WordBreak2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "catsanddog",
                listOf("cat", "cats", "and", "sand", "dog"),
                listOf(
                    "cats and dog",
                    "cat sand dog"
                )
            ),
            Arguments.of(
                "pineapplepenapple",
                listOf("apple", "pen", "applepen", "pine", "pineapple"),
                listOf(
                    "pine apple pen apple",
                    "pineapple pen apple",
                    "pine applepen apple"
                )
            ),
            Arguments.of(
                "catsandog",
                listOf("cats", "dog", "sand", "and", "cat"),
                listOf<String>()
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return all valid sentences`(s: String, wordDict: List<String>, expected: List<String>) {
        val actual = WordBreak2.wordBreak(s, wordDict)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}