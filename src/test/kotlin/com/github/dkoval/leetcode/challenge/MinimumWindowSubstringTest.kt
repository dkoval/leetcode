package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumWindowSubstring.MinimumWindowSubstringRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumWindowSubstringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "ADOBECODEBANC",
                "ABC",
                "BANC"
            ),
            Arguments.of(
                "a",
                "t",
                ""
            ),
            Arguments.of(
                "a",
                "aa",
                ""
            ),
            Arguments.of(
                "aa",
                "aa",
                "aa"
            ),
            Arguments.of(
                "bdab",
                "ab",
                "ab"
            )
        )
    }

    @Nested
    inner class MinimumWindowSubstringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum window substring of s such that every character in t (including duplicates) is included in the window`(
            s: String,
            t: String,
            expected: String
        ) {
            MinimumWindowSubstringRev1().test(s, t, expected)
        }
    }
}

private fun MinimumWindowSubstring.test(s: String, t: String, expected: String) {
    val actual = minWindow(s, t)
    assertEquals(expected, actual)
}
