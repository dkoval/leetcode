package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PalindromePairs.PalindromePairsNaive
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PalindromePairsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("abcd", "dcba", "lls", "s", "sssll"),
                listOf(
                    listOf(0, 1),
                    listOf(1, 0),
                    listOf(3, 2),
                    listOf(2, 4)
                )
            ),
            Arguments.of(
                arrayOf("bat", "tab", "cat"),
                listOf(
                    listOf(0, 1),
                    listOf(1, 0)
                )
            ),
            Arguments.of(
                arrayOf("a", ""),
                listOf(
                    listOf(0, 1),
                    listOf(1, 0)
                )
            )
        )
    }

    @Nested
    inner class PalindromePairsNaiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all the pairs of the distinct indices (i, j) in the given list, so that the concatenation of words_i + words_j is a palindrome`(
            words: Array<String>,
            expected: List<List<Int>>
        ) {
            PalindromePairsNaive().test(words, expected)
        }
    }

    private fun PalindromePairs.test(words: Array<String>, expected: List<List<Int>>) {
        val actual = palindromePairs(words)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}