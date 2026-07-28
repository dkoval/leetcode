package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SmallestPalindromicRearrangement1.SmallestPalindromicRearrangement1Rev1
import com.github.dkoval.leetcode.challenge.SmallestPalindromicRearrangement1.SmallestPalindromicRearrangement1Rev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class SmallestPalindromicRearrangement1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of("z", "z"),
            Arguments.of("babab", "abbba"),
            Arguments.of("daccad", "acddca")
        )
    }

    @Nested
    inner class SmallestPalindromicRearrangement1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the lexicographically smallest palindromic rearrangement of s`(
            s: String,
            expected: String
        ) {
            SmallestPalindromicRearrangement1Rev1().test(s, expected)
        }
    }

    @Nested
    inner class SmallestPalindromicRearrangement1Rev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the lexicographically smallest palindromic rearrangement of s`(
            s: String,
            expected: String
        ) {
            SmallestPalindromicRearrangement1Rev2().test(s, expected)
        }
    }
}

private fun SmallestPalindromicRearrangement1.test(s: String, expected: String) {
    val actual = smallestPalindrome(s)
    assertEquals(expected, actual)
}
