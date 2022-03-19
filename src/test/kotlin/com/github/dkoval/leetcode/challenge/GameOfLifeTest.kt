package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.GameOfLife.GameOfLifeNaive
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class GameOfLifeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 1),
                    intArrayOf(1, 1, 1),
                    intArrayOf(0, 0, 0)
                ),
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(1, 0, 1),
                    intArrayOf(0, 1, 1),
                    intArrayOf(0, 1, 0)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 0)
                ),
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 1)
                )
            )
        )
    }

    @Nested
    inner class GameOfLifeNaiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the next state`(board: Array<IntArray>, expected: Array<IntArray>) {
            GameOfLifeNaive().gameOfLife(board)
            assertArrayEquals(board, expected)
        }
    }
}