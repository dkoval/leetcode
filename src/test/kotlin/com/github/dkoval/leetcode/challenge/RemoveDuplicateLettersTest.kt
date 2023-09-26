package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RemoveDuplicateLetters.RemoveDuplicateLettersGreedyWithIncreasingStack
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RemoveDuplicateLettersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "bcabc",
                "abc"
            ),
            Arguments.of(
                "cbacdcbc",
                "acdb"
            )
        )
    }

    @Nested
    inner class RemoveDuplicateLettersGreedyWithIncreasingStackTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should remove duplicate letters`(s: String, expected: String) {
            RemoveDuplicateLettersGreedyWithIncreasingStack().test(s, expected)
        }
    }
}

private fun RemoveDuplicateLetters.test(s: String, expected: String) {
    val actual = removeDuplicateLetters(s)
    assertEquals(expected, actual)
}
