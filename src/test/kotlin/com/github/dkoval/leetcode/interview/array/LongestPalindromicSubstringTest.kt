package com.github.dkoval.leetcode.interview.array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LongestPalindromicSubstringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "babad",
                "bab",
                "aba"
            ),
            Arguments.of(
                "cbbd",
                "bb"
            ),
            Arguments.of(
                "",
                ""
            )
        )
    }

    @Nested
    inner class LongestPalindromicSubstringBruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the longest palindromic substring`(s: String, expected: String) {
            LongestPalindromicSubstringBruteForce.test(s, expected)
        }
    }

    @Nested
    inner class LongestPalindromicSubstringUsingExpandOutApproachTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the longest palindromic substring`(s: String, expected: String) {
            LongestPalindromicSubstringUsingExpandOutApproach.test(s, expected)
        }
    }

    private fun LongestPalindromicSubstring.test(s: String, expected: String) {
        val actual = longestPalindrome(s)
        assertEquals(expected, actual)
    }
}