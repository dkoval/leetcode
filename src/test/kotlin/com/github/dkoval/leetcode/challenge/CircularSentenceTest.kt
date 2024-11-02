package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CircularSentence.CircularSentenceRev1
import com.github.dkoval.leetcode.challenge.CircularSentence.CircularSentenceRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CircularSentenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("leetcode exercises sound delightful", true),
            Arguments.of("eetcode", true),
            Arguments.of("Leetcode is cool", false)
        )
    }

    @Nested
    inner class CircularSentenceRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if it is circular`(sentence: String, expected: Boolean) {
            CircularSentenceRev1().test(sentence, expected)
        }
    }

    @Nested
    inner class CircularSentenceRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if it is circular`(sentence: String, expected: Boolean) {
            CircularSentenceRev2().test(sentence, expected)
        }
    }
}

private fun CircularSentence.test(sentence: String, expected: Boolean) {
    val actual = isCircularSentence(sentence)
    assertEquals(expected, actual)
}
