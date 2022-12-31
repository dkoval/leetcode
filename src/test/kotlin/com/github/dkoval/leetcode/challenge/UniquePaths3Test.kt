package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class UniquePaths3Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(0, 0, 2, -1)
                ),
                // Explanation: We have the following two paths:
                // 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
                // 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 2)
                ),
                // Explanation: We have the following four paths:
                // 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
                // 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
                // 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
                // 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(2, 0)
                ),
                // There is no path that walks over every empty square exactly once.
                // Note that the starting and ending square can be anywhere in the grid
                0
            )
        )
    }

    @Nested
    inner class UniquePaths3Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number walks from the starting square to the ending square, that walk over every non-obstacle square exactly once`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            UniquePaths3Rev1.test(grid, expected)
        }
    }

    @Nested
    inner class UniUniquePaths3Rev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number walks from the starting square to the ending square, that walk over every non-obstacle square exactly once`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            UniquePaths3Rev2.test(grid, expected)
        }
    }

    private fun UniquePaths3.test(grid: Array<IntArray>, expected: Int) {
        val actual = uniquePathsIII(grid)
        assertEquals(expected, actual)
    }
}