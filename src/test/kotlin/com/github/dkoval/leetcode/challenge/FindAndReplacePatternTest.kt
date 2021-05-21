package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FindAndReplacePatternTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf("abc", "deq", "mee", "aqq", "dkd", "ccc"),
                "abb",
                listOf("mee", "aqq")
            ),
            Arguments.of(
                arrayOf("a", "b", "c"),
                "a",
                listOf("a", "b", "c")
            ),
            Arguments.of(
                arrayOf("ef", "fq", "ao", "at", "lx"),
                "ya",
                listOf("ef","fq","ao","at","lx")
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return in any order a list of words that match pattern`(
        words: Array<String>,
        pattern: String,
        expected: List<String>
    ) {
        val actual = FindAndReplacePattern().findAndReplacePattern(words, pattern)
        println(actual)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}