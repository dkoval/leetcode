package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class WordPatternTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "abba",
                "dog cat cat dog",
                true
            ),
            Arguments.of(
                "abba",
                "dog cat cat fish",
                false
            ),
            Arguments.of(
                "aaaa",
                "dog cat cat dog",
                false
            ),
            Arguments.of(
                "abba",
                "dog dog dog dog",
                false
            )
        )
    }

    @Nested
    inner class WordPatternRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if a string follows the pattern`(pattern: String, s: String, expected: Boolean) {
            WordPatternRev2.test(pattern, s, expected)
        }
    }

    @Nested
    inner class WordPatternRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if a string follows the pattern`(pattern: String, s: String, expected: Boolean) {
            WordPatternRev1.test(pattern, s, expected)
        }
    }

    private fun WordPattern.test(pattern: String, s: String, expected: Boolean) {
        val actual = wordPattern(pattern, s)
        assertEquals(expected, actual)
    }
}