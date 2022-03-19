package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PairsOfSongsWithTotalDurationsDivisibleBy60.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PairsOfSongsWithTotalDurationsDivisibleBy60Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(30, 20, 150, 100, 40),
                3
            ),
            Arguments.of(
                intArrayOf(60, 60, 60),
                3
            ),
            Arguments.of(
                intArrayOf(418, 204, 77, 278, 239, 457, 284, 263, 372, 279, 476, 416, 360, 18),
                1
            )
        )
    }

    @Nested
    inner class PairsOfSongsWithTotalDurationsDivisibleBy60BruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of pairs of songs for which their total duration in seconds is divisible by 60`(
            time: IntArray,
            expected: Int
        ) {
            PairsOfSongsWithTotalDurationsDivisibleBy60BruteForce().test(time, expected)
        }
    }

    @Nested
    inner class PairsOfSongsWithTotalDurationsDivisibleBy60CountingRemaindersTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of pairs of songs for which their total duration in seconds is divisible by 60`(
            time: IntArray,
            expected: Int
        ) {
            PairsOfSongsWithTotalDurationsDivisibleBy60CountingRemainders().test(time, expected)
        }
    }

    @Nested
    inner class PairsOfSongsWithTotalDurationsDivisibleBy60CountingRemaindersRefactoredTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of pairs of songs for which their total duration in seconds is divisible by 60`(
            time: IntArray,
            expected: Int
        ) {
            PairsOfSongsWithTotalDurationsDivisibleBy60CountingRemaindersRefactored().test(time, expected)
        }
    }

    private fun PairsOfSongsWithTotalDurationsDivisibleBy60.test(time: IntArray, expected: Int) {
        val actual = numPairsDivisibleBy60(time)
        assertEquals(expected, actual)
    }
}