package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class IslandPerimeterTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> =
            Stream.of(
                Arguments.of(
                    arrayOf(
                        intArrayOf(1)
                    ),
                    4
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(0, 1, 0, 0),
                        intArrayOf(1, 1, 1, 0),
                        intArrayOf(0, 1, 0, 0),
                        intArrayOf(1, 1, 0, 0)
                    ),
                    16
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 1),
                        intArrayOf(1, 1)
                    ),
                    8
                )
            )
    }

    @Nested
    inner class IslandPerimeterIterTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine the perimeter of the island`(grid: Array<IntArray>, expected: Int) {
            IslandPerimeterIter.test(grid, expected)
        }
    }

    @Nested
    inner class IslandPerimeterDFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine the perimeter of the island`(grid: Array<IntArray>, expected: Int) {
            IslandPerimeterDFS.test(grid, expected)
        }
    }

    private fun IslandPerimeter.test(grid: Array<IntArray>, expected: Int) {
        val actual = islandPerimeter(grid)
        assertEquals(expected, actual)
    }
}