package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfMatchingSubsequences.NumberOfMatchingSubsequencesBruteForceTLE
import com.github.dkoval.leetcode.challenge.NumberOfMatchingSubsequences.NumberOfMatchingSubsequencesUsingMapWithBinarySearch
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class NumberOfMatchingSubsequencesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "abcde",
                arrayOf("a", "bb", "acd", "ace"),
                3
            ),
            Arguments.of(
                "dsahjpjauf",
                arrayOf("ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"),
                2
            )
        )
    }

    @Nested
    inner class NumberOfMatchingSubsequencesBruteForceTLETest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of words_i that is a subsequence of s`(
            s: String,
            words: Array<String>,
            expected: Int
        ) {
            NumberOfMatchingSubsequencesBruteForceTLE().test(s, words, expected)
        }
    }

    @Nested
    inner class NumberOfMatchingSubsequencesUsingMapWithBinarySearchTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of words_i that is a subsequence of s`(
            s: String,
            words: Array<String>,
            expected: Int
        ) {
            NumberOfMatchingSubsequencesUsingMapWithBinarySearch().test(s, words, expected)
        }
    }

    private fun NumberOfMatchingSubsequences.test(s: String, words: Array<String>, expected: Int) {
        val actual = numMatchingSubseq(s, words)
        assertEquals(expected, actual)
    }
}