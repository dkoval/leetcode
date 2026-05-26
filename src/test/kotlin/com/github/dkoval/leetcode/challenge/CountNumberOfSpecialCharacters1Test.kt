package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountNumberOfSpecialCharacters1.CountNumberOfSpecialCharacters1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class CountNumberOfSpecialCharacters1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "aaAbcBC",
                3
            ),
            Arguments.of(
                "abc",
                0
            ),
            Arguments.of(
                "abBCab",
                1
            )
        )
    }

    @Nested
    inner class CountNumberOfSpecialCharacters1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of special letters`(word: String, expected: Int) {
            CountNumberOfSpecialCharacters1Rev1().test(word, expected)
        }
    }
}

private fun CountNumberOfSpecialCharacters1.test(word: String, expected: Int) {
    val actual = numberOfSpecialChars(word)
    assertEquals(expected, actual)
}
