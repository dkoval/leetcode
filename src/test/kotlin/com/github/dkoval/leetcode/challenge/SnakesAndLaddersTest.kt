package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SnakesAndLadders.SnakesAndLaddersRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SnakesAndLaddersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(-1, -1, -1, -1, -1, -1),
                    intArrayOf(-1, -1, -1, -1, -1, -1),
                    intArrayOf(-1, -1, -1, -1, -1, -1),
                    intArrayOf(-1, 35, -1, -1, 13, -1),
                    intArrayOf(-1, -1, -1, -1, -1, -1),
                    intArrayOf(-1, 15, -1, -1, -1, -1)
                ),
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(-1, -1),
                    intArrayOf(-1, 3)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(-1, -1, -1),
                    intArrayOf(-1, 9, 8),
                    intArrayOf(-1, 8, 9)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(-1, -1, -1, -1, -1, 38, -1),
                    intArrayOf(-1, 26, -1, 28, 49, 42, -1),
                    intArrayOf(-1, 37, 14, 39, 48, 24, 48),
                    intArrayOf(6, -1, 41, 29, 2, -1, 28),
                    intArrayOf(-1, -1, -1, 7, -1, -1, 16),
                    intArrayOf(21, 19, 21, -1, -1, -1, 48),
                    intArrayOf(-1, -1, 2, -1, 35, -1, -1)
                ),
                2
            )
        )
    }

    @Nested
    inner class SnakesAndLaddersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the least number of moves required to reach the square n^2`(
            board: Array<IntArray>,
            expected: Int
        ) {
            SnakesAndLaddersRev1().test(board, expected)
        }
    }
}

private fun SnakesAndLadders.test(board: Array<IntArray>, expected: Int) {
    val actual = snakesAndLadders(board)
    assertEquals(expected, actual)
}
