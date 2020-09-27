package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindDifferenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "abcd",
                "abcde",
                'e'
            )
        )
    }

    @Nested
    inner class FindDifferenceUsingSumTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the letter that was added in t`(s: String, t: String, expected: Char) {
            FindDifferenceUsingSum.test(s, t, expected)
        }
    }

    @Nested
    inner class FindDifferenceUsingXorTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the letter that was added in t`(s: String, t: String, expected: Char) {
            FindDifferenceUsingXor.test(s, t, expected)
        }
    }

    @Nested
    inner class FindDifferenceUsingSumJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the letter that was added in t`(s: String, t: String, expected: Char) {
            FindDifferenceUsingSumJava().test(s, t, expected)
        }
    }

    @Nested
    inner class FindDifferenceUsingXorJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the letter that was added in t`(s: String, t: String, expected: Char) {
            FindDifferenceUsingXorJava().test(s, t, expected)
        }
    }

    private fun FindDifference.test(s: String, t: String, expected: Char) {
        val actual = findTheDifference(s, t)
        assertEquals(expected, actual)
    }
}