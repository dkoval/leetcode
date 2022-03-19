package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ReverseWordsInString.ReverseWordsInStringJava
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ReverseWordsInStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("the sky is blue", "blue is sky the"),
            Arguments.of("  hello world!  ", "world! hello"),
            Arguments.of("a good   example", "example good a")
        )
    }

    @Nested
    inner class ReverseWordsInStringJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reverse words in a String`(s: String, expected: String) {
            ReverseWordsInStringJava().test(s, expected)
        }
    }

    @Nested
    inner class ReverseWordsInStringKtTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reverse words in a String`(s: String, expected: String) {
            ReverseWordsInStringKt.test(s, expected)
        }
    }

    private fun ReverseWordsInString.test(s: String, expected: String) {
        val actual = reverseWords(s)
        assertEquals(expected, actual)
    }
}