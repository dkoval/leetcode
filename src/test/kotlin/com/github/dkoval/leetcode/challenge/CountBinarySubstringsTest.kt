package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountBinarySubstrings.CountBinarySubstringsRev1
import com.github.dkoval.leetcode.challenge.CountBinarySubstrings.CountBinarySubstringsRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class CountBinarySubstringsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                "00110011",
                6
            ),
            arguments(
                "10101",
                4
            )
        )
    }

    @Nested
    inner class InputArgumentsProviderRev1 : ArgumentsProvider {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should count the number of non-empty substrings that have the same number of 0's and 1's`(
            s: String,
            expected: Int
        ) {
            CountBinarySubstringsRev1().test(s, expected)
        }
    }

    @Nested
    inner class InputArgumentsProviderRev2 : ArgumentsProvider {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should count the number of non-empty substrings that have the same number of 0's and 1's`(
            s: String,
            expected: Int
        ) {
            CountBinarySubstringsRev2().test(s, expected)
        }
    }
}

private fun CountBinarySubstrings.test(s: String, expected: Int) {
    val actual = countBinarySubstrings(s)
    assertEquals(expected, actual)
}
