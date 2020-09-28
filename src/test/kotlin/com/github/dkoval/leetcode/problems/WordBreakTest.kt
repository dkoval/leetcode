package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class WordBreakTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "leetcode",
                listOf("leet", "code"),
                // "leetcode" can be segmented as "leet code"
                true
            ),
            Arguments.of(
                "applepenapple",
                listOf("apple", "pen"),
                // "applepenapple" can be segmented as "apple pen apple".
                // Note that you are allowed to reuse a dictionary
                true
            ),
            Arguments.of(
                "catsandog",
                listOf("cats", "dog", "sand", "and", "cat"),
                false
            )
        )
    }

    @Nested
    inner class WordBreakDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine if s can be segmented into a space-separated sequence of one or more dictionary words`(
            s: String,
            wordDict: List<String>,
            expected: Boolean
        ) {
            WordBreakDPTopDown.test(s, wordDict, expected)
        }
    }

    @Nested
    inner class WordBreakDPTopDownJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine if s can be segmented into a space-separated sequence of one or more dictionary words`(
            s: String,
            wordDict: List<String>,
            expected: Boolean
        ) {
            WordBreakDPTopDownJava().test(s, wordDict, expected)
        }
    }

    @Nested
    inner class WordBreakDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine if s can be segmented into a space-separated sequence of one or more dictionary words`(
            s: String,
            wordDict: List<String>,
            expected: Boolean
        ) {
            WordBreakDPBottomUp.test(s, wordDict, expected)
        }
    }

    private fun WordBreak.test(s: String, wordDict: List<String>, expected: Boolean) {
        val actual = wordBreak(s, wordDict)
        assertEquals(expected, actual)
    }
}