package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.WordSubsets.WordSubsetsAccepted
import com.github.dkoval.leetcode.challenge.WordSubsets.WordSubsetsTLE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class WordSubsetsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("amazon", "apple", "facebook", "google", "leetcode"),
                arrayOf("e", "o"),
                listOf("facebook", "google", "leetcode"),
            ),
            Arguments.of(
                arrayOf("amazon", "apple", "facebook", "google", "leetcode"),
                arrayOf("l", "e"),
                listOf("apple", "google", "leetcode")
            ),
            Arguments.of(
                arrayOf("amazon", "apple", "facebook", "google", "leetcode"),
                arrayOf("e", "oo"),
                listOf("facebook", "google"),
            ),
            Arguments.of(
                arrayOf("amazon", "apple", "facebook", "google", "leetcode"),
                arrayOf("lo", "eo"),
                listOf("google", "leetcode")
            ),
            Arguments.of(
                arrayOf("amazon", "apple", "facebook", "google", "leetcode"),
                arrayOf("ec", "oc", "ceo"),
                listOf("facebook", "leetcode")
            )
        )
    }

    @Nested
    inner class WordSubsetsTLETest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a list of all universal words in A`(A: Array<String>, B: Array<String>, expected: List<String>) {
            WordSubsetsTLE().test(A, B, expected)
        }
    }

    @Nested
    inner class WordSubsetsAcceptedTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a list of all universal words in A`(A: Array<String>, B: Array<String>, expected: List<String>) {
            WordSubsetsAccepted().test(A, B, expected)
        }
    }

    private fun WordSubsets.test(A: Array<String>, B: Array<String>, expected: List<String>) {
        val actual = wordSubsets(A, B)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}