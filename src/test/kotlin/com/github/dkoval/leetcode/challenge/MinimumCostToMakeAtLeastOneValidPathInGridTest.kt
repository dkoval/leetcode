package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumCostToMakeAtLeastOneValidPathInGrid.MinimumCostToMakeAtLeastOneValidPathInGridRev1
import com.github.dkoval.leetcode.challenge.MinimumCostToMakeAtLeastOneValidPathInGrid.MinimumCostToMakeAtLeastOneValidPathInGridRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumCostToMakeAtLeastOneValidPathInGridTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1, 1, 1),
                    intArrayOf(2, 2, 2, 2),
                    intArrayOf(1, 1, 1, 1),
                    intArrayOf(2, 2, 2, 2)
                ),
                3
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1, 3),
                    intArrayOf(3, 2, 2),
                    intArrayOf(1, 1, 4)
                ),
                0
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(4, 3)
                ),
                1
            )
        )
    }

    @Nested
    inner class MinimumCostToMakeAtLeastOneValidPathInGridRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum cost to make the grid have at least one valid path`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            MinimumCostToMakeAtLeastOneValidPathInGridRev1().test(grid, expected)
        }
    }

    @Nested
    inner class MinimumCostToMakeAtLeastOneValidPathInGridRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum cost to make the grid have at least one valid path`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            MinimumCostToMakeAtLeastOneValidPathInGridRev2().test(grid, expected)
        }
    }
}

private fun MinimumCostToMakeAtLeastOneValidPathInGrid.test(grid: Array<IntArray>, expected: Int) {
    val actual = minCost(grid)
    assertEquals(expected, actual)
}
