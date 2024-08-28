package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.CountSubIslands.CountSubIslandsDFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountSubIslandsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1, 1, 0, 0),
                    intArrayOf(0, 1, 1, 1, 1),
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(1, 0, 0, 0, 0),
                    intArrayOf(1, 1, 0, 1, 1)
                ),
                arrayOf(
                    intArrayOf(1, 1, 1, 0, 0),
                    intArrayOf(0, 0, 1, 1, 1),
                    intArrayOf(0, 1, 0, 0, 0),
                    intArrayOf(1, 0, 1, 1, 0),
                    intArrayOf(0, 1, 0, 1, 0)
                ),
                3
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 1, 0, 1),
                    intArrayOf(1, 1, 1, 1, 1),
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1, 1),
                    intArrayOf(1, 0, 1, 0, 1)
                ),
                arrayOf(
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1, 1),
                    intArrayOf(0, 1, 0, 1, 0),
                    intArrayOf(0, 1, 0, 1, 0),
                    intArrayOf(1, 0, 0, 0, 1)
                ),
                2
            )
        )
    }

    @Nested
    inner class CountSubIslandsDFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of islands in grid2 that are considered sub-islands`(
            grid1: Array<IntArray>,
            grid2: Array<IntArray>,
            expected: Int
        ) {
            CountSubIslandsDFS().test(grid1, grid2, expected)
        }
    }

}

private fun CountSubIslands.test(grid1: Array<IntArray>, grid2: Array<IntArray>, expected: Int) {
    val actual = countSubIslands(grid1, grid2)
    assertEquals(expected, actual)
}
