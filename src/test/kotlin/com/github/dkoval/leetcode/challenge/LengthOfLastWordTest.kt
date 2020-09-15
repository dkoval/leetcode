package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LengthOfLastWordTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "Hello World",
                5
            ),
            Arguments.of(
                "Hello World  ",
                5
            ),
            Arguments.of(
                "a",
                1
            ),
            Arguments.of(
                "a ",
                1
            )
        )
    }

    @Nested
    inner class LengthOfLastWordSolution1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of last word`(s: String, expected: Int) {
            LengthOfLastWordSolution1.test(s, expected)
        }
    }

    @Nested
    inner class LengthOfLastWordSolution2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of last word`(s: String, expected: Int) {
            LengthOfLastWordSolution2.test(s, expected)
        }
    }

    private fun LengthOfLastWord.test(s: String, expected: Int) {
        val actual = lengthOfLastWord(s)
        assertEquals(expected, actual)
    }
}