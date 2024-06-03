package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.AppendCharactersToStringToMakeSubsequence.AppendCharactersToStringToMakeSubsequenceRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class AppendCharactersToStringToMakeSubsequenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "coaching",
                "coding",
                4
            ),
            Arguments.of(
                "abcde",
                "a",
                0
            ),
            Arguments.of(
                "z",
                "abcde",
                5
            ),
            Arguments.of(
                "lbg",
                "g",
                0
            )
        )
    }

    @Nested
    inner class AppendCharactersToStringToMakeSubsequenceRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of characters that need to be appended to the end of s so that t becomes a subsequence of s`(
            s: String,
            t: String,
            expected: Int
        ) {
            AppendCharactersToStringToMakeSubsequenceRev1().test(s, t, expected)
        }
    }
}

private fun AppendCharactersToStringToMakeSubsequence.test(s: String, t: String, expected: Int) {
    val actual = appendCharacters(s, t)
    assertEquals(expected, actual)
}
