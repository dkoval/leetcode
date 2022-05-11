package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountSortedVowelStrings.CountSortedVowelStringsDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountSortedVowelStringsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(1, 5),
            Arguments.of(2, 15),
            Arguments.of(33, 66045)
        )
    }

    @Nested
    inner class CountSortedVowelStringsDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of strings of length n that consist only of vowels and are lexicographically sorted`(
            n: Int,
            expected: Int
        ) {
            CountSortedVowelStringsDPTopDown().test(n, expected)
        }
    }

    private fun CountSortedVowelStrings.test(n: Int, expected: Int) {
        val actual = countVowelStrings(n)
        assertEquals(expected, actual)
    }
}