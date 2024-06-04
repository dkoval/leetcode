package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LongestPalindrome.LongestPalindromeRev2
import com.github.dkoval.leetcode.challenge.LongestPalindrome.LongestPalindromeRev3
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LongestPalindromeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            // One longest palindrome that can be built is "dccaccd", whose length is 7.
            Arguments.of(
                "abccccdd",
                7
            ),
            Arguments.of(
                "a",
                1
            )
        )
    }

    @Nested
    inner class LongestPalindromeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the length of the longest palindromes`(s: String, expected: Int) {
            LongestPalindromeRev1.test(s, expected)
        }
    }

    @Nested
    inner class LongestPalindromeRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the length of the longest palindromes`(s: String, expected: Int) {
            LongestPalindromeRev2().test(s, expected)
        }
    }

    @Nested
    inner class LongestPalindromeRev3Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the length of the longest palindromes`(s: String, expected: Int) {
            LongestPalindromeRev3().test(s, expected)
        }
    }
}

private fun LongestPalindrome.test(s: String, expected: Int) {
    val actual = longestPalindrome(s)
    assertEquals(expected, actual)
}
