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
    inner class FindDifferenceKtTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the letter that was added in t`(s: String, t: String, expected: Char) {
            FindDifferenceKt.test(s, t, expected)
        }
    }

    @Nested
    inner class FindDifferenceJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the letter that was added in t`(s: String, t: String, expected: Char) {
            FindDifferenceJava().test(s, t, expected)
        }
    }

    private fun FindDifference.test(s: String, t: String, expected: Char) {
        val actual = findTheDifference(s, t)
        assertEquals(expected, actual)
    }
}