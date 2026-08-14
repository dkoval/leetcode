package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumLengthSubstringWithTwoOccurrences.MaximumLengthSubstringWithTwoOccurrencesRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class MaximumLengthSubstringWithTwoOccurrencesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "bcbbbcba",
                4
            ),
            Arguments.of(
                "aaaa",
                2
            )
        )
    }

    @Nested
    inner class MaximumLengthSubstringWithTwoOccurrencesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum length of a substring such that it contains at most two occurrences of each character`(
            s: String,
            expected: Int
        ) {
            MaximumLengthSubstringWithTwoOccurrencesRev1().test(s, expected)
        }
    }
}

private fun MaximumLengthSubstringWithTwoOccurrences.test(s: String, expected: Int) {
    val actual = maximumLengthSubstring(s)
    assertEquals(expected, actual)
}
