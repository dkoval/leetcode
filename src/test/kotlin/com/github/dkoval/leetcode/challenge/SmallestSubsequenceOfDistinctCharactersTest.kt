package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SmallestSubsequenceOfDistinctCharacters.SmallestSubsequenceOfDistinctCharactersRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class SmallestSubsequenceOfDistinctCharactersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of("bcabc", "abc"),
            Arguments.of("cbacdcbc", "acdb"),
            Arguments.of("cdadabcc", "adbc")
        )
    }

    @Nested
    inner class SmallestSubsequenceOfDistinctCharactersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once`(
            s: String,
            expected: String
        ) {
            SmallestSubsequenceOfDistinctCharactersRev1().test(s, expected)
        }
    }
}

private fun SmallestSubsequenceOfDistinctCharacters.test(s: String, expected: String) {
    val actual = smallestSubsequence(s)
    assertEquals(expected, actual)
}
