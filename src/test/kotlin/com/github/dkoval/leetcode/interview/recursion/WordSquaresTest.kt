package com.github.dkoval.leetcode.interview.recursion

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class WordSquaresTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
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

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `should find all word squares`(words: Array<String>, expected: List<List<String>>) {
        val actual = WordSquares().wordSquares(words)
        Assertions.assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}