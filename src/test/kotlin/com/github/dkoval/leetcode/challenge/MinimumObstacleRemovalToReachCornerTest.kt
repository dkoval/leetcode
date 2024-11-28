package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumObstacleRemovalToReachCorner.MinimumObstacleRemovalToReachCornerRev1
import com.github.dkoval.leetcode.challenge.MinimumObstacleRemovalToReachCorner.MinimumObstacleRemovalToReachCornerRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumObstacleRemovalToReachCornerTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1, 1),
                    intArrayOf(1, 1, 0),
                    intArrayOf(1, 1, 0)
                ),
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1, 0, 0, 0),
                    intArrayOf(0, 1, 0, 1, 0),
                    intArrayOf(0, 0, 0, 1, 0)
                ),
                0
            )
        )
    }

    @Nested
    inner class MinimumObstacleRemovalToReachCornerRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of obstacles to remove so you can move from the upper left corner to the lower right corner`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            MinimumObstacleRemovalToReachCornerRev1().test(grid, expected)
        }
    }

    @Nested
    inner class MinimumObstacleRemovalToReachCornerRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of obstacles to remove so you can move from the upper left corner to the lower right corner`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            MinimumObstacleRemovalToReachCornerRev2().test(grid, expected)
        }
    }
}

private fun MinimumObstacleRemovalToReachCorner.test(grid: Array<IntArray>, expected: Int) {
    val actual = minimumObstacles(grid)
    assertEquals(expected, actual)
}
