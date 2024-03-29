package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MatchsticksToSquare.MatchsticksToSquareRecursiveWithBacktracking
import com.github.dkoval.leetcode.challenge.MatchsticksToSquare.MatchsticksToSquareUsingBitmaskWithMemoization
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MatchsticksToSquareTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 1, 2, 2, 2),
                true
            ),
            Arguments.of(
                intArrayOf(3, 3, 3, 3, 4),
                false
            ),
            Arguments.of(
                intArrayOf(5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3),
                true
            )
        )
    }

    @Nested
    inner class MatchsticksToSquareRecursiveWithBacktrackingTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if you can make a square with matchsticks`(matchsticks: IntArray, expected: Boolean) {
            MatchsticksToSquareRecursiveWithBacktracking().test(matchsticks, expected)
        }
    }

    @Nested
    inner class MatchsticksToSquareUsingBitmaskWithMemoizationTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if you can make a square with matchsticks`(matchsticks: IntArray, expected: Boolean) {
            MatchsticksToSquareUsingBitmaskWithMemoization()
                .test(matchsticks, expected)
        }
    }

    private fun MatchsticksToSquare.test(matchsticks: IntArray, expected: Boolean) {
        val actual = makesquare(matchsticks)
        assertEquals(expected, actual)
    }
}