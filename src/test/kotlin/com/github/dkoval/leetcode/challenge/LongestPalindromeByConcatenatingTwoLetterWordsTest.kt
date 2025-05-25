package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LongestPalindromeByConcatenatingTwoLetterWords.LongestPalindromeByConcatenatingTwoLetterWordsRev1
import com.github.dkoval.leetcode.challenge.LongestPalindromeByConcatenatingTwoLetterWords.LongestPalindromeByConcatenatingTwoLetterWordsRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LongestPalindromeByConcatenatingTwoLetterWordsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("lc", "cl", "gg"),
                6
            ),
            Arguments.of(
                arrayOf("ab", "ty", "yt", "lc", "cl", "ab"),
                8
            ),
            Arguments.of(
                arrayOf("cc", "ll", "xx"),
                2
            ),
            Arguments.of(
                arrayOf(
                    "zb",
                    "bb",
                    "zy",
                    "bz",
                    "yb",
                    "yz",
                    "zz",
                    "zy",
                    "zb",
                    "zz",
                    "by",
                    "by",
                    "bb",
                    "bz",
                    "bz",
                    "yy",
                    "bz",
                    "zz",
                    "bz",
                    "yy",
                    "yz",
                    "yz",
                    "zz",
                    "zy",
                    "by",
                    "zy",
                    "bb",
                    "yz",
                    "yy",
                    "by",
                    "zy",
                    "yz",
                    "yy",
                    "by",
                    "zz",
                    "bb",
                    "yb",
                    "by",
                    "yy",
                    "zb",
                    "bb",
                    "yz",
                    "yb",
                    "zz",
                    "by",
                    "yb",
                    "zy",
                    "bb",
                    "yz",
                    "zb",
                    "zy",
                    "yy",
                    "bb",
                    "by",
                    "yb",
                    "yb",
                    "bb",
                    "bb"
                ),
                110
            )
        )
    }

    @Nested
    inner class LongestPalindromeByConcatenatingTwoLetterWordsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest palindrome that you can create`(
            words: Array<String>,
            expected: Int
        ) {
            LongestPalindromeByConcatenatingTwoLetterWordsRev1().test(words, expected)
        }
    }

    @Nested
    inner class LongestPalindromeByConcatenatingTwoLetterWordsRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest palindrome that you can create`(
            words: Array<String>,
            expected: Int
        ) {
            LongestPalindromeByConcatenatingTwoLetterWordsRev2().test(words, expected)
        }
    }
}

private fun LongestPalindromeByConcatenatingTwoLetterWords.test(words: Array<String>, expected: Int) {
    val actual = longestPalindrome(words)
    assertEquals(expected, actual)
}
