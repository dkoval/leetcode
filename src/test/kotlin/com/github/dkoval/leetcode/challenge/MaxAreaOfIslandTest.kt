package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaxAreaOfIsland.MaxAreaOfIslandBFS
import com.github.dkoval.leetcode.challenge.MaxAreaOfIsland.MaxAreaOfIslandDFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaxAreaOfIslandTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
                    intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
                    intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
                ),
                6
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0)
                ),
                0
            )
        )
    }

    @Nested
    inner class MaxAreaOfIslandDFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `return the maximum area of an island in grid`(grid: Array<IntArray>, expected: Int) {
            MaxAreaOfIslandDFS().test(grid, expected)
        }
    }

    @Nested
    inner class MaxAreaOfIslandBFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `return the maximum area of an island in grid`(grid: Array<IntArray>, expected: Int) {
            MaxAreaOfIslandBFS().test(grid, expected)
        }
    }

    private fun MaxAreaOfIsland.test(grid: Array<IntArray>, expected: Int) {
        val actual = maxAreaOfIsland(grid)
        assertEquals(expected, actual)
    }
}