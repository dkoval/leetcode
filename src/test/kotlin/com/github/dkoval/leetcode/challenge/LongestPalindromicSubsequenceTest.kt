package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.problems.LongestPalindromicSubsequence
import com.github.dkoval.leetcode.problems.LongestPalindromicSubsequence.LongestPalindromicSubsequenceDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LongestPalindromicSubsequenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("bbbab", 4),
            Arguments.of("cbbd", 2)
        )
    }

    @Nested
    inner class LongestPalindromicSubsequenceDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the longest palindromic subsequence's length in s`(s: String, expected: Int) {
            LongestPalindromicSubsequenceDPTopDown().test(s, expected)
        }
    }
}

private fun LongestPalindromicSubsequence.test(s: String, expected: Int) {
    val actual = longestPalindromeSubseq(s)
    assertEquals(expected, actual)
}
