package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountOfSubstringsContainingEveryVowelAndKConsonants2.CountOfSubstringsContainingEveryVowelAndKConsonants2Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class CountOfSubstringsContainingEveryVowelAndKConsonants2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "aeioqq",
                1,
                0L
            ),
            Arguments.of(
                "aeiou",
                0,
                1L
            ),
            Arguments.of(
                "ieaouqqieaouqq",
                1,
                3L
            )
        )
    }

    @Nested
    inner class CountOfSubstringsContainingEveryVowelAndKConsonants2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of substrings that contain every vowel at least once and exactly k consonants`(
            s: String,
            k: Int,
            expected: Long
        ) {
            CountOfSubstringsContainingEveryVowelAndKConsonants2Rev1().test(s, k, expected)
        }
    }
}

private fun CountOfSubstringsContainingEveryVowelAndKConsonants2.test(s: String, k: Int, expected: Long) {
    val actual = countOfSubstrings(s, k)
    assertEquals(expected, actual)
}
