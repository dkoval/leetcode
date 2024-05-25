package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumScoreWordsFormedByLetters.MaximumScoreWordsFormedByLettersRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumScoreWordsFormedByLettersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("dog", "cat", "dad", "good"),
                charArrayOf('a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'),
                intArrayOf(1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                23
            ),
            Arguments.of(
                arrayOf("xxxz", "ax", "bx", "cx"),
                charArrayOf('z', 'a', 'b', 'c', 'x', 'x', 'x'),
                intArrayOf(4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10),
                27
            ),
            Arguments.of(
                arrayOf("leetcode"),
                charArrayOf('l', 'e', 't', 'c', 'o', 'd'),
                intArrayOf(0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0),
                0
            )
        )
    }

    @Nested
    inner class MaximumScoreWordsFormedByLettersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum score of any valid set of words formed by using the given letters`(
            words: Array<String>,
            letters: CharArray,
            scores: IntArray,
            expected: Int
        ) {
            MaximumScoreWordsFormedByLettersRev1().test(words, letters, scores, expected)
        }
    }
}

private fun MaximumScoreWordsFormedByLetters.test(
    words: Array<String>,
    letters: CharArray,
    scores: IntArray,
    expected: Int
) {
    val actual = maxScoreWords(words, letters, scores)
    assertEquals(expected, actual)
}
