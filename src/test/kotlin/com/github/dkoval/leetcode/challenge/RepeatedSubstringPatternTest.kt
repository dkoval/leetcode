package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RepeatedSubstringPatternTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "abab", true
            ),
            Arguments.of(
                "aba", false
            ),
            Arguments.of(
                "abcabcabcabc", true
            ),
            Arguments.of(
                "a", false
            ),
            Arguments.of(
                "aa", true
            ),
            Arguments.of(
                "abcab", false
            ),
            Arguments.of(
                "aabaaba", false
            )
        )
    }

    @Nested
    inner class RepeatedSubstringPatternStraightForwardTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if the given string can be constructed by taking a substring of it and appending multiple copies of the substring together`(
            s: String,
            expected: Boolean
        ) {
            RepeatedSubstringPatternStraightForward.test(s, expected)
        }
    }

    @Nested
    inner class RepeatedSubstringPatternRegexTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if the given string can be constructed by taking a substring of it and appending multiple copies of the substring together`(
            s: String,
            expected: Boolean
        ) {
            RepeatedSubstringPatternRegex.test(s, expected)
        }
    }

    private fun RepeatedSubstringPattern.test(s: String, expected: Boolean) {
        val actual = repeatedSubstringPattern(s)
        assertEquals(expected, actual)
    }
}