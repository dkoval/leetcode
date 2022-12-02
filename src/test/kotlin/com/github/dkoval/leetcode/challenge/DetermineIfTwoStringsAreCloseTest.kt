package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DetermineIfTwoStringsAreClose.DetermineIfTwoStringsAreCloseRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DetermineIfTwoStringsAreCloseTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("abc", "bca", true),
            Arguments.of("a", "aa", false),
            Arguments.of("cabbba", "abbccc", true)
        )
    }

    @Nested
    inner class DetermineIfTwoStringsAreCloseRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine if two strings are close`(word1: String, word2: String, expected: Boolean) {
            DetermineIfTwoStringsAreCloseRev1().test(word1, word2, expected)
        }
    }

    private fun DetermineIfTwoStringsAreClose.test(word1: String, word2: String, expected: Boolean) {
        val actual = closeStrings(word1, word2)
        assertEquals(expected, actual)
    }
}