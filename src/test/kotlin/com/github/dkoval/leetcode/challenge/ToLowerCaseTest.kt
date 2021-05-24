package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ToLowerCase.ToLowerCaseAscii
import com.github.dkoval.leetcode.challenge.ToLowerCase.ToLowerCaseLib
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ToLowerCaseTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "Hello",
                "hello"
            ),
            Arguments.of(
                "here",
                "here"
            ),
            Arguments.of(
                "LOVELY",
                "lovely"
            )
        )
    }

    @Nested
    inner class ToLowerCaseLibTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the string after replacing every uppercase letter with the same lowercase letter`(
            s: String,
            expected: String
        ) {
            ToLowerCaseLib().test(s, expected)
        }
    }

    @Nested
    inner class ToLowerCaseAsciiTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the string after replacing every uppercase letter with the same lowercase letter`(
            s: String,
            expected: String
        ) {
            ToLowerCaseAscii().test(s, expected)
        }
    }

    private fun ToLowerCase.test(s: String, expected: String) {
        val actual = toLowerCase(s)
        assertEquals(expected, actual)
    }
}