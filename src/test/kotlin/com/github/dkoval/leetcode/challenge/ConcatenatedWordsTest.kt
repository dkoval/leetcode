package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ConcatenatedWords.ConcatenatedWordsRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ConcatenatedWordsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"),
                listOf("catsdogcats", "dogcatsdog", "ratcatdogcat")
            ),
            Arguments.of(
                arrayOf("cat", "dog", "catdog"),
                listOf("catdog")
            )
        )
    }

    @Nested
    inner class ConcatenatedWordsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all the concatenated words in the given list of words`(words: Array<String>, expected: List<String>) {
            ConcatenatedWordsRev1().test(words, expected)
        }
    }
}

private fun ConcatenatedWords.test(words: Array<String>, expected: List<String>) {
    val actual = findAllConcatenatedWordsInADict(words)
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
}
