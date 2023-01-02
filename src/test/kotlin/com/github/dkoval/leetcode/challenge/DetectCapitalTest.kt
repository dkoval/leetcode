package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DetectCapitalTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("USA", true),
            Arguments.of("leetcode", true),
            Arguments.of("Google", true),
            Arguments.of("FlaG", false),
            Arguments.of("aBcd", false)
        )
    }

    @Nested
    inner class DetectCapitalRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should judge whether the usage of capitals in it is right or not`(word: String, expected: Boolean) {
            DetectCapitalRev1.test(word, expected)
        }
    }

    @Nested
    inner class DetectCapitalRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should judge whether the usage of capitals in it is right or not`(word: String, expected: Boolean) {
            DetectCapitalRev2.test(word, expected)
        }
    }

    private fun DetectCapital.test(word: String, expected: Boolean) {
        val actual = detectCapitalUse(word)
        assertEquals(expected, actual)
    }
}