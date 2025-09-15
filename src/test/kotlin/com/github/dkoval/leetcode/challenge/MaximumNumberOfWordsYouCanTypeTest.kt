package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumNumberOfWordsYouCanType.MaximumNumberOfWordsYouCanTypeRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumNumberOfWordsYouCanTypeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("hello world", "ad", 1),
            Arguments.of("leet code", "lt", 1),
            Arguments.of("leet code", "e", 0)
        )
    }

    @Nested
    inner class MaximumNumberOfWordsYouCanTypeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of words you can type`(
            text: String,
            brokenLetters: String,
            expected: Int
        ) {
            MaximumNumberOfWordsYouCanTypeRev1().test(text, brokenLetters, expected)
        }
    }
}

private fun MaximumNumberOfWordsYouCanType.test(text: String, brokenLetters: String, expected: Int) {
    val actual = canBeTypedWords(text, brokenLetters)
    assertEquals(expected, actual)
}
