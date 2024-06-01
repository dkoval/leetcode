package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ScoreOfString.ScoreOfStringRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ScoreOfStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("hello", 13),
            Arguments.of("zaz", 50)
        )
    }

    @Nested
    inner class ScoreOfStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the score of s`(s: String, expected: Int) {
            ScoreOfStringRev1().test(s, expected)
        }
    }
}

private fun ScoreOfString.test(s: String, expected: Int) {
    val actual = scoreOfString(s)
    assertEquals(expected, actual)
}
