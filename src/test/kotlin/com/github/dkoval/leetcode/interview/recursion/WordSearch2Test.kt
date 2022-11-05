package com.github.dkoval.leetcode.interview.recursion

import com.github.dkoval.leetcode.interview.recursion.WordSearch2.WordSearch2UsingTrieAndDFS
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class WordSearch2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
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

    @Nested
    inner class WordSearch2UsingTrieAndDFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all words on the board`(board: Array<CharArray>, words: Array<String>, expected: List<String>) {
            WordSearch2UsingTrieAndDFS().test(board, words, expected)
        }
    }

    private fun WordSearch2.test(board: Array<CharArray>, words: Array<String>, expected: List<String>) {
        val actual = findWords(board, words)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}