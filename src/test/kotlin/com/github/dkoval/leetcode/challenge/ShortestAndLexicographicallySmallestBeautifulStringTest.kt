package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ShortestAndLexicographicallySmallestBeautifulString.ShortestAndLexicographicallySmallestBeautifulStringRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class ShortestAndLexicographicallySmallestBeautifulStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of("100011001", 3, "11001"),
            Arguments.of("1011", 2, "11"),
            Arguments.of("000", 1, ""),
            Arguments.of("11000111", 1, "1"),
            Arguments.of("001", 1, "1"),
            Arguments.of("0000101111001", 5, "101111")
        )
    }

    @Nested
    inner class ShortestAndLexicographicallySmallestBeautifulStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the lexicographically smallest beautiful substring of string s`(
            s: String,
            k: Int,
            expected: String
        ) {
            ShortestAndLexicographicallySmallestBeautifulStringRev1().test(s, k, expected)
        }
    }
}

private fun ShortestAndLexicographicallySmallestBeautifulString.test(s: String, k: Int, expected: String) {
    val actual = shortestBeautifulSubstring(s, k)
    assertEquals(expected, actual)
}
