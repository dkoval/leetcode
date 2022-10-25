package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CheckIfTwoStringArraysAreEquivalent.CheckIfTwoStringArraysAreEquivalentRev1
import com.github.dkoval.leetcode.challenge.CheckIfTwoStringArraysAreEquivalent.CheckIfTwoStringArraysAreEquivalentRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CheckIfTwoStringArraysAreEquivalentTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("ab", "c"),
                arrayOf("a", "bc"),
                true
            ),
            Arguments.of(
                arrayOf("a", "cb"),
                arrayOf("ab", "c"),
                false
            ),
            Arguments.of(
                arrayOf("abc", "d", "defg"),
                arrayOf("abcddefg"),
                true
            )
        )
    }

    @Nested
    inner class CheckIfTwoStringArraysAreEquivalentTestRev1 {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if two string arrays are equivalent`(
            word1: Array<String>,
            word2: Array<String>,
            expected: Boolean
        ) {
            CheckIfTwoStringArraysAreEquivalentRev1().test(word1, word2, expected)
        }
    }

    @Nested
    inner class CheckIfTwoStringArraysAreEquivalentTestRev2 {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if two string arrays are equivalent`(
            word1: Array<String>,
            word2: Array<String>,
            expected: Boolean
        ) {
            CheckIfTwoStringArraysAreEquivalentRev2().test(word1, word2, expected)
        }
    }

    private fun CheckIfTwoStringArraysAreEquivalent.test(word1: Array<String>, word2: Array<String>, expected: Boolean) {
        val actual = arrayStringsAreEqual(word1, word2)
        assertEquals(expected, actual)
    }
}