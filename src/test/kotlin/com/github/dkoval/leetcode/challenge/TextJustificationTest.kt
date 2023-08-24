package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.TextJustification.TextJustificationRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class TextJustificationTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("This", "is", "an", "example", "of", "text", "justification."),
                16,
                listOf("This    is    an", "example  of text", "justification.  ")
            ),
            Arguments.of(
                arrayOf("What", "must", "be", "acknowledgment", "shall", "be"),
                16,
                listOf("What   must   be", "acknowledgment  ", "shall be        ")
            ),
            Arguments.of(
                arrayOf(
                    "Science",
                    "is",
                    "what",
                    "we",
                    "understand",
                    "well",
                    "enough",
                    "to",
                    "explain",
                    "to",
                    "a",
                    "computer.",
                    "Art",
                    "is",
                    "everything",
                    "else",
                    "we",
                    "do"
                ),
                20,
                listOf(
                    "Science  is  what we",
                    "understand      well",
                    "enough to explain to",
                    "a  computer.  Art is",
                    "everything  else  we",
                    "do                  "
                )
            )
        )
    }

    @Nested
    inner class TextJustificationRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should format the text such that each line has exactly maxWidth characters and is fully (left and right) justified`(
            words: Array<String>,
            maxWidth: Int,
            expected: List<String>
        ) {
            TextJustificationRev1().test(words, maxWidth, expected)
        }
    }
}

private fun TextJustification.test(words: Array<String>, maxWidth: Int, expected: List<String>) {
    val actual = fullJustify(words, maxWidth)
    assertEquals(expected, actual)
}
