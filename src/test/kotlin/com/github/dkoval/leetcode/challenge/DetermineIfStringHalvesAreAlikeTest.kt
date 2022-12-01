package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DetermineIfStringHalvesAreAlike.DetermineIfStringHalvesAreAlikeRev1
import com.github.dkoval.leetcode.challenge.DetermineIfStringHalvesAreAlike.DetermineIfStringHalvesAreAlikeRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DetermineIfStringHalvesAreAlikeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("book", true),
            Arguments.of("textbook", false),
            Arguments.of("MerryChristmas", false),
            Arguments.of("AbCdEfGh", true)
        )
    }

    @Nested
    inner class DetermineIfStringHalvesAreAlikeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine of string halves are alike`(s: String, expected: Boolean) {
            DetermineIfStringHalvesAreAlikeRev1().test(s, expected)
        }
    }

    @Nested
    inner class DetermineIfStringHalvesAreAlikeRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine of string halves are alike`(s: String, expected: Boolean) {
            DetermineIfStringHalvesAreAlikeRev2().test(s, expected)
        }
    }

    private fun DetermineIfStringHalvesAreAlike.test(s: String, expected: Boolean) {
        val actual = halvesAreAlike(s)
        assertEquals(expected, actual)
    }
}