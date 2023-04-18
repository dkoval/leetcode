package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MergeStringsAlternately.MergeStringsAlternatelyRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MergeStringsAlternatelyTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("abc", "pqr", "apbqcr"),
            Arguments.of( "ab", "pqrs", "apbqrs"),
            Arguments.of("abcd", "pq", "apbqcd")
        )
    }

    @Nested
    inner class MergeStringsAlternatelyRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the merged string`(word1: String, word2: String, expected: String) {
            MergeStringsAlternatelyRev1().test(word1, word2, expected)
        }
    }

    @Nested
    inner class MergeStringsAlternatelyRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the merged string`(word1: String, word2: String, expected: String) {
            MergeStringsAlternately.MergeStringsAlternatelyRev2().test(word1, word2, expected)
        }
    }
}

private fun MergeStringsAlternately.test(word1: String, word2: String, expected: String) {
    val actual = mergeAlternately(word1, word2)
    assertEquals(expected, actual)
}
