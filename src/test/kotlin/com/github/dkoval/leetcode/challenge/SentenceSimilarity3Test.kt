package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SentenceSimilarity3.SentenceSimilarity3Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SentenceSimilarity3Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "My name is Haley",
                "My Haley",
                true
            ),
            Arguments.of(
                "of",
                "A lot of words",
                false
            ),
            Arguments.of(
                "Eating right now",
                "Eating",
                true
            ),
            Arguments.of(
                "Ogn WtWj HneS",
                "Ogn WtWj HneS",
                true
            ),
            Arguments.of(
                "qbaVXO Msgr aEWD v ekcb",
                "Msgr aEWD ekcb",
                false
            ),
            Arguments.of(
                "eTUny i b R UFKQJ EZx JBJ Q xXz",
                "eTUny i R EZx JBJ xXz",
                false
            )
        )
    }

    @Nested
    inner class SentenceSimilarity3Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if sentence1 and sentence2 are similar`(
            sentence1: String,
            sentence2: String,
            expected: Boolean
        ) {
            SentenceSimilarity3Rev1().test(sentence1, sentence2, expected)
        }
    }
}

private fun SentenceSimilarity3.test(sentence1: String, sentence2: String, expected: Boolean) {
    val actual = areSentencesSimilar(sentence1, sentence2)
    assertEquals(actual, expected)
}
