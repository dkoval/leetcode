package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.UniqueMorseCodeWords.UniqueMorseCodeWordsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class UniqueMorseCodeWordsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("gin", "zen", "gig", "msg"),
                2
            ),
            Arguments.of(
                arrayOf("a"),
                1
            )
        )
    }

    @Nested
    inner class UniqueMorseCodeWordsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of different transformations among all words`(words: Array<String>, expected: Int) {
            UniqueMorseCodeWordsRev1().test(words, expected)
        }
    }

    private fun UniqueMorseCodeWords.test(words: Array<String>, expected: Int) {
        val actual = uniqueMorseRepresentations(words)
        assertEquals(expected, actual)
    }
}