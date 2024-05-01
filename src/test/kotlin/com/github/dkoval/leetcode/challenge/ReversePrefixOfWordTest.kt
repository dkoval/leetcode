package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ReversePrefixOfWord.ReversePrefixOfWordRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ReversePrefixOfWordTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "abcdefd",
                'd',
                "dcbaefd"
            ),
            Arguments.of(
                "xyxzxe",
                'z',
                "zxyxxe"
            ),
            Arguments.of(
                "abcd",
                'z',
                "abcd"
            )
        )
    }

    @Nested
    inner class ReversePrefixOfWordRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reverse prefix of a word`(word: String, ch: Char, expected: String) {
            ReversePrefixOfWordRev1().test(word, ch, expected)
        }
    }
}

private fun ReversePrefixOfWord.test(word: String, ch: Char, expected: String) {
    val actual = reversePrefix(word, ch)
    assertEquals(expected, actual)
}
