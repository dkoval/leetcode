package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindDifference.*
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
            ),
            Arguments.of(
                "",
                "y",
                'y'
            )
        )
    }

    @Nested
    inner class FindDifferenceUsingSumKtTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the letter that was added in t`(s: String, t: String, expected: Char) {
            FindDifferenceUsingSumKt.test(s, t, expected)
        }
    }

    @Nested
    inner class FindDifferenceUsingXorKtTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the letter that was added in t`(s: String, t: String, expected: Char) {
            FindDifferenceUsingXorKt.test(s, t, expected)
        }
    }

    @Nested
    inner class FindDifferenceUsingCountsRev1JavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the letter that was added in t`(s: String, t: String, expected: Char) {
            FindDifferenceUsingCountsRev1Java().test(s, t, expected)
        }
    }

    @Nested
    inner class FindDifferenceUsingCountsRev2JavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the letter that was added in t`(s: String, t: String, expected: Char) {
            FindDifferenceUsingCountsRev2Java().test(s, t, expected)
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
}

private fun FindDifference.test(s: String, t: String, expected: Char) {
    val actual = findTheDifference(s, t)
    assertEquals(expected, actual)
}
