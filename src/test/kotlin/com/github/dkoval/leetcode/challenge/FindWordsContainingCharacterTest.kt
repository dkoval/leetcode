package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindWordsContainingCharacter.FindWordsContainingCharacterRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindWordsContainingCharacterTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("leet", "code"),
                'e',
                listOf(0, 1)
            ),
            Arguments.of(
                arrayOf("abc", "bcd", "aaaa", "cbc"),
                'a',
                listOf(0, 2)
            ),
            Arguments.of(
                arrayOf("abc", "bcd", "aaaa", "cbc"),
                'z',
                emptyList<Integer>()
            )
        )
    }

    @Nested
    inner class FindWordsContainingCharacterRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return indices of words that contain the given character`(
            words: Array<String>,
            character: Char,
            expected: List<Int>
        ) {
            FindWordsContainingCharacterRev1().test(words, character, expected)
        }
    }
}

private fun FindWordsContainingCharacter.test(
    words: Array<String>, x: Char, expected: List<Int>
) {
    val actual = findWordsContaining(words, x)
    assertEquals(expected, actual)
}
