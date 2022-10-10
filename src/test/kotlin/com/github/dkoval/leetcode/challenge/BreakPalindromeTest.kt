package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.BreakPalindrome.BreakPalindromeRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BreakPalindromeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "abccba",
                "aaccba"
            ),
            Arguments.of(
                "a",
                ""
            ),
            Arguments.of(
                "aa",
                "ab"
            ),
            Arguments.of(
                "aba",
                "abb"
            ),
            Arguments.of(
                "abba",
                "aaba"
            )
        )
    }

    @Nested
    inner class BreakPalindromeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should break a palindrome`(palindrome: String, expected: String) {
            BreakPalindrome.BreakPalindromeRev1().test(palindrome, expected)
        }
    }

    @Nested
    inner class BreakPalindromeRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should break a palindrome`(palindrome: String, expected: String) {
            BreakPalindromeRev2().test(palindrome, expected)
        }
    }

    private fun BreakPalindrome.test(palindrome: String, expected: String) {
        val actual = breakPalindrome(palindrome)
        assertEquals(expected, actual)
    }
}