package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PredictWinner.PredictWinnerBruteForce
import com.github.dkoval.leetcode.challenge.PredictWinner.PredictWinnerDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PredictWinnerTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 5, 2),
                false
            ),
            Arguments.of(
                intArrayOf(1, 5, 233, 7),
                true
            )
        )
    }

    @Nested
    inner class PredictWinnerBruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if Player 1 can win the game`(nums: IntArray, expected: Boolean) {
            PredictWinnerBruteForce().test(nums, expected)
        }
    }

    @Nested
    inner class PredictWinnerDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if Player 1 can win the game`(nums: IntArray, expected: Boolean) {
            PredictWinnerDPTopDown().test(nums, expected)
        }
    }
}

private fun PredictWinner.test(nums: IntArray, expected: Boolean) {
    val actual = predictTheWinner(nums)
    assertEquals(expected, actual)
}
