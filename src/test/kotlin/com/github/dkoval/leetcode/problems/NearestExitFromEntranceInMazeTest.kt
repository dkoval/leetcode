package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.NearestExitFromEntranceInMaze.NearestExitFromEntranceInMazeUsingBFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NearestExitFromEntranceInMazeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    charArrayOf('+', '+', '.', '+'),
                    charArrayOf('.', '.', '.', '+'),
                    charArrayOf('+', '+', '+', '.'),
                ),
                intArrayOf(1, 2),
                1
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('+', '+', '+'),
                    charArrayOf('.', '.', '.'),
                    charArrayOf('+', '+', '+')
                ),
                intArrayOf(1, 0),
                2
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('.', '+')
                ),
                intArrayOf(0, 0),
                -1
            )
        )
    }

    @Nested
    inner class NearestExitFromEntranceInMazeUsingBFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists`(
            maze: Array<CharArray>,
            entrance: IntArray,
            expected: Int
        ) {
            NearestExitFromEntranceInMazeUsingBFS().test(maze, entrance, expected)
        }
    }

    private fun NearestExitFromEntranceInMaze.test(maze: Array<CharArray>, entrance: IntArray, expected: Int) {
        val actual = nearestExit(maze, entrance)
        assertEquals(expected, actual)
    }
}