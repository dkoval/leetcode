package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindLexicographicallyLargestStringFromBox1.FindLexicographicallyLargestStringFromBox1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindLexicographicallyLargestStringFromBox1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "dbca",
                2,
                "dbc"
            ),
            Arguments.of(
                "gggg",
                4,
                "g"
            ),
            Arguments.of(
                "bif",
                2,
                "if"
            ),
            Arguments.of(
                "gh",
                1,
                "gh"
            ),
        )
    }

    @Nested
    inner class FindLexicographicallyLargestStringFromBox1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the lexicographically largest string from the box after all the rounds are finished`(
            word: String,
            numFriends: Int,
            expected: String
        ) {
            FindLexicographicallyLargestStringFromBox1Rev1().test(word, numFriends, expected)
        }
    }
}

private fun FindLexicographicallyLargestStringFromBox1Rev1.test(word: String, numFriends: Int, expected: String) {
    val actual = answerString(word, numFriends)
    assertEquals(expected, actual)
}
