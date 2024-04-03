package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.WordSearch.WordSearchRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class WordSearchTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    charArrayOf('A', 'B', 'C', 'E'),
                    charArrayOf('S', 'F', 'C', 'S'),
                    charArrayOf('A', 'D', 'E', 'E')
                ),
                "ABCCED",
                true
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('A', 'B', 'C', 'E'),
                    charArrayOf('S', 'F', 'C', 'S'),
                    charArrayOf('A', 'D', 'E', 'E')
                ),
                "SEE",
                true
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('A', 'B', 'C', 'E'),
                    charArrayOf('S', 'F', 'C', 'S'),
                    charArrayOf('A', 'D', 'E', 'E')
                ),
                "ABCB",
                false
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('a')
                ),
                "a",
                true
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('A', 'B', 'C', 'E'),
                    charArrayOf('S', 'F', 'E', 'S'),
                    charArrayOf('A', 'D', 'E', 'E')
                ),
                "ABCESEEEFS",
                true
            )
        )
    }

    @Nested
    inner class WordSearchTestRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find if the word exists in the grid`(board: Array<CharArray>, word: String, expected: Boolean) {
            WordSearchRev1.test(board, word, expected)
        }
    }

    @Nested
    inner class WordSearchTestRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find if the word exists in the grid`(board: Array<CharArray>, word: String, expected: Boolean) {
            WordSearchRev2().test(board, word, expected)
        }
    }
}

private fun WordSearch.test(board: Array<CharArray>, word: String, expected: Boolean) {
    val actual = exist(board, word)
    assertEquals(expected, actual)
}
