package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountVowelStringsInRanges.CountVowelStringsInRangesRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountVowelStringsInRangesTest {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("aba", "bcb", "ece", "aa", "e"),
                arrayOf(
                    intArrayOf(0, 2),
                    intArrayOf(1, 4),
                    intArrayOf(1, 1)
                ),
                intArrayOf(2, 3, 0)
            ),
            Arguments.of(
                arrayOf("a", "e", "i"),
                arrayOf(
                    intArrayOf(0, 2),
                    intArrayOf(0, 1),
                    intArrayOf(2, 2)
                ),
                intArrayOf(3, 2, 1)
            )
        )
    }

    @Nested
    inner class CountVowelStringsInRangesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return answers to the queries`(words: Array<String>, queries: Array<IntArray>, expected: IntArray) {
            CountVowelStringsInRangesRev1().test(words, queries, expected)
        }
    }
}

private fun CountVowelStringsInRanges.test(words: Array<String>, queries: Array<IntArray>, expected: IntArray) {
    val actual = vowelStrings(words, queries)
    assertArrayEquals(expected, actual)
}
