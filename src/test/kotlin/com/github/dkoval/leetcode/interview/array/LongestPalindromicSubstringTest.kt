package com.github.dkoval.leetcode.interview.array

import com.github.dkoval.leetcode.challenge.LongestPalindromicSubstring
import com.github.dkoval.leetcode.challenge.LongestPalindromicSubstring.*
import org.assertj.core.api.Assertions.assertThat
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
                setOf("bab", "aba"),
            ),
            Arguments.of(
                "cbbd",
                setOf("bb")
            ),
            Arguments.of(
                "a",
                setOf("a")
            ),
            Arguments.of(
                "aa",
                setOf("aa")
            ),
            Arguments.of(
                "aaa",
                setOf("aaa")
            )
        )
    }

    @Nested
    inner class LongestPalindromicSubstringBruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the longest palindromic substring`(s: String, expected: Set<String>) {
            LongestPalindromicSubstringBruteForce.test(s, expected)
        }
    }

    @Nested
    inner class LongestPalindromicSubstringExpandAroundCenterTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the longest palindromic substring`(s: String, expected: Set<String>) {
            LongestPalindromicSubstringExpandAroundCenter.test(s, expected)
        }
    }

    @Nested
    inner class LongestPalindromicSubstringExpandAroundCenterRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the longest palindromic substring`(s: String, expected: Set<String>) {
            LongestPalindromicSubstringExpandAroundCenterRev1().test(s, expected)
        }
    }

    @Nested
    inner class LongestPalindromicSubstringExpandAroundCenterRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the longest palindromic substring`(s: String, expected: Set<String>) {
            LongestPalindromicSubstringExpandAroundCenterRev2().test(s, expected)
        }
    }

    @Nested
    inner class LongestPalindromicSubstringDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the longest palindromic substring`(s: String, expected: Set<String>) {
            LongestPalindromicSubstringDPBottomUp().test(s, expected)
        }
    }
}

private fun LongestPalindromicSubstring.test(s: String, expected: Set<String>) {
    val actual = longestPalindrome(s)
    assertThat(actual).isIn(expected)
}
