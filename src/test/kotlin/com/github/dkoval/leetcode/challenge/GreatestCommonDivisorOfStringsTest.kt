package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.GreatestCommonDivisorOfStrings.GreatestCommonDivisorOfStringsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class GreatestCommonDivisorOfStringsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "ABCABC",
                "ABC",
                "ABC"
            ),
            Arguments.of(
                "ABABAB",
                "ABAB",
                "AB"
            ),
            Arguments.of(
                "LEET",
                "CODE",
                ""
            )
        )
    }

    @Nested
    inner class GreatestCommonDivisorOfStringsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the largest string x such that x divides both str1 and str2`(str1: String, str2: String, expected: String) {
            GreatestCommonDivisorOfStringsRev1().test(str1, str2, expected)
        }
    }
}

private fun GreatestCommonDivisorOfStrings.test(str1: String, str2: String, expected: String) {
    val actual = gcdOfStrings(str1, str2)
    assertEquals(expected, actual)
}
