package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.WordBreak2.WordBreak2Rev2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class WordBreak2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
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
                emptyList<String>()
            )
        )
    }

    @Nested
    inner class WordBreak2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all valid sentences`(s: String, wordDict: List<String>, expected: List<String>) {
            WordBreak2Rev1.test(s, wordDict, expected)
        }
    }

    @Nested
    inner class WordBreak2Rev2Test {
        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all valid sentences`(s: String, wordDict: List<String>, expected: List<String>) {
            WordBreak2Rev2().test(s, wordDict, expected)
        }
    }
}

private fun WordBreak2.test(s: String, wordDict: List<String>, expected: List<String>) {
    val actual = wordBreak(s, wordDict)
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
}
