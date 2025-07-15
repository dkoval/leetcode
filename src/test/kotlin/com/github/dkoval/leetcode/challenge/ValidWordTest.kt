package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ValidWord.ValidWordRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ValidWordTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("234Adas", true),
            Arguments.of("b3", false),
            Arguments.of("a3\$e", false),
            Arguments.of("Ya$", false)
        )
    }

    @Nested
    inner class ValidWordRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if the word is valid`(word: String, expected: Boolean) {
            ValidWordRev1().test(word, expected)
        }
    }
}

private fun ValidWord.test(word: String, expected: Boolean) {
    val actual = isValid(word)
    assertEquals(expected, actual)
}
