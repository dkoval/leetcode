package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountNumberOfConsistentStrings.CountNumberOfConsistentStringsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountNumberOfConsistentStringsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "ab",
                arrayOf("ad", "bd", "aaab", "baa", "badab"),
                2
            ),
            Arguments.of(
                "abc",
                arrayOf("a", "b", "c", "ab", "ac", "bc", "abc"),
                7
            ),
            Arguments.of(
                "cad",
                arrayOf("cc", "acd", "b", "ba", "bac", "bad", "ac", "d"),
                4
            )
        )
    }

    @Nested
    inner class CountNumberOfConsistentStringsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of consistent strings in the array words`(
            allowed: String,
            words: Array<String>,
            expected: Int
        ) {
            CountNumberOfConsistentStringsRev1().test(allowed, words, expected)
        }
    }
}

private fun CountNumberOfConsistentStrings.test(allowed: String, words: Array<String>, expected: Int) {
    val actual = countConsistentStrings(allowed, words)
    assertEquals(expected, actual)
}
