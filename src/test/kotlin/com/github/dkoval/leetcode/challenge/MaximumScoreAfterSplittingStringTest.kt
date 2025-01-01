package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumScoreAfterSplittingString.MaximumScoreAfterSplittingStringRev1
import com.github.dkoval.leetcode.challenge.MaximumScoreAfterSplittingString.MaximumScoreAfterSplittingStringRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumScoreAfterSplittingStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("011101", 5),
            Arguments.of("00111", 5),
            Arguments.of("1111", 3),
            Arguments.of("00", 1)
        )
    }

    @Nested
    inner class MaximumScoreAfterSplittingStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum score after splitting the string into two non-empty substrings`(
            s: String,
            expected: Int
        ) {
            MaximumScoreAfterSplittingStringRev1().test(s, expected)
        }
    }

    @Nested
    inner class MaximumScoreAfterSplittingStringRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum score after splitting the string into two non-empty substrings`(
            s: String,
            expected: Int
        ) {
            MaximumScoreAfterSplittingStringRev2().test(s, expected)
        }
    }
}

private fun MaximumScoreAfterSplittingString.test(s: String, expected: Int) {
    val actual = maxScore(s)
    assertEquals(expected, actual)
}
