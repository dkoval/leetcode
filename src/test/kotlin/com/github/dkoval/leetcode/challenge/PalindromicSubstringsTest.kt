package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PalindromicSubstrings.PalindromicSubstringsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PalindromicSubstringsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "abc",
                // palindromic substrings: "a", "b", "c".
                3
            ),
            Arguments.of(
                "aaa",
                // palindromic substrings: "a", "a", "a", "aa", "aa", "aaa"
                6
            )
        )
    }

    @Nested
    inner class PalindromicSubstringsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return number of palindromic substrings`(s: String, expected: Int) {
            PalindromicSubstringsRev1().test(s, expected)
        }
    }
}

private fun PalindromicSubstrings.test(s: String, expected: Int) {
    val actual = countSubstrings(s)
    assertEquals(expected, actual)
}
