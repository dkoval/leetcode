package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.ReverseWordsInString3.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ReverseWordsInString3Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "Let's take LeetCode contest",
                "s'teL ekat edoCteeL tsetnoc"
            ),
            Arguments.of(
                "God Ding",
                "doG gniD"
            ),
            Arguments.of(
                "Bang!",
                "!gnaB"
            )
        )
    }

    @Nested
    inner class ReverseWordsInString3Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order`(
            s: String,
            expected: String
        ) {
            ReverseWordsInString3Rev1().test(s, expected)
        }
    }

    @Nested
    inner class ReverseWordsInString3Rev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order`(
            s: String,
            expected: String
        ) {
            ReverseWordsInString3Rev2().test(s, expected)
        }
    }

    @Nested
    inner class ReverseWordsInString3Rev3Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order`(
            s: String,
            expected: String
        ) {
            ReverseWordsInString3Rev3().test(s, expected)
        }
    }
}

private fun ReverseWordsInString3.test(s: String, expected: String) {
    val actual = reverseWords(s)
    assertEquals(expected, actual)
}
