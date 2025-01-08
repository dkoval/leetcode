package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountPrefixAndSuffixPairs1.CountPrefixAndSuffixPairs1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountPrefixAndSuffixPairs1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("a", "aba", "ababa", "aa"),
                4
            ),
            Arguments.of(
                arrayOf("pa", "papa", "ma", "mama"),
                2
            ),
            Arguments.of(
                arrayOf("abab", "ab"),
                0
            )
        )
    }

    @Nested
    inner class CountPrefixAndSuffixPairs1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of pairs and isPrefixAndSuffix(words(i), words(j)) is true`(
            words: Array<String>,
            expected: Int
        ) {
            CountPrefixAndSuffixPairs1Rev1().test(words, expected)
        }
    }
}

private fun CountPrefixAndSuffixPairs1.test(words: Array<String>, expected: Int) {
    val actual = countPrefixSuffixPairs(words)
    assertEquals(expected, actual)
}
