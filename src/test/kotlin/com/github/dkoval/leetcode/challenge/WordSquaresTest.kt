package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class WordSquaresTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("area", "lead", "wall", "lady", "ball"),
                listOf(
                    listOf(
                        "wall",
                        "area",
                        "lead",
                        "lady"
                    ),
                    listOf(
                        "ball",
                        "area",
                        "lead",
                        "lady"
                    )
                )
            ),
            Arguments.of(
                arrayOf("abat", "baba", "atan", "atal"),
                listOf(
                    listOf(
                        "baba",
                        "abat",
                        "baba",
                        "atan"
                    ),
                    listOf(
                        "baba",
                        "abat",
                        "baba",
                        "atal"
                    )
                )
            )
        )
    }

    @Nested
    inner class WordSquaresRecursiveWithTrieTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find all word squares you can build from a given set of words`(
            words: Array<String>,
            expected: List<List<String>>
        ) {
            WordSquaresRecursiveWithTrie.test(words, expected)
        }
    }

    @Nested
    inner class WordSquaresRecursiveWithTrieJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find all word squares you can build from a given set of words`(
            words: Array<String>,
            expected: List<List<String>>
        ) {
            WordSquaresRecursiveWithTrieJava().test(words, expected)
        }
    }

    private fun WordSquares.test(words: Array<String>, expected: List<List<String>>) {
        val actual = wordSquares(words)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}