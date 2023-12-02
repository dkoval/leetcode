package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindWordsThatCanBeFormedByCharacters.FindWordsThatCanBeFormedByCharactersRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindWordsThatCanBeFormedByCharactersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("cat", "bt", "hat", "tree"),
                "atach",
                6
            ),
            Arguments.of(
                arrayOf("hello", "world", "leetcode"),
                "welldonehoneyr",
                10
            )
        )
    }

    @Nested
    inner class FindWordsThatCanBeFormedByCharactersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the sum of lengths of all good strings in words`(
            words: Array<String>,
            chars: String,
            expected: Int
        ) {
            FindWordsThatCanBeFormedByCharactersRev1().test(words, chars, expected)
        }
    }
}

private fun FindWordsThatCanBeFormedByCharacters.test(words: Array<String>, chars: String, expected: Int) {
    val actual = countCharacters(words, chars)
    assertEquals(expected, actual)
}
