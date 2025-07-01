package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindOriginalTypedString1.FindOriginalTypedString1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindOriginalTypedString1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("abbcccc", 5),
            Arguments.of("abcd", 1),
            Arguments.of("aaaa", 4)
        )
    }

    @Nested
    inner class FindOriginalTypedString1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the total number of possible original strings`(word: String, expected: Int) {
            FindOriginalTypedString1Rev1().test(word, expected)
        }
    }
}

private fun FindOriginalTypedString1.test(word: String, expected: Int) {
    val actual = possibleStringCount(word)
    assertEquals(expected, actual)
}
