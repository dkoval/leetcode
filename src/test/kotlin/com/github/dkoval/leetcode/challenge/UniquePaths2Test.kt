package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.UniquePaths2.UniquePaths2DPBottomUp
import com.github.dkoval.leetcode.challenge.UniquePaths2.UniquePaths2DPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class UniquePaths2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 0)
                ),
                // There are two ways to reach the bottom-right corner:
                // 1. Right -> Right -> Down -> Down
                // 2. Down -> Down -> Right -> Right
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 0)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1)
                ),
                0
            )
        )
    }

    @Nested
    inner class UniquePaths2DPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of unique paths`(grid: Array<IntArray>, expected: Int) {
            UniquePaths2DPBottomUp().test(grid, expected)
        }
    }

    @Nested
    inner class UniquePaths2DPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of unique paths`(grid: Array<IntArray>, expected: Int) {
            UniquePaths2DPTopDown().test(grid, expected)
        }
    }
}

private fun UniquePaths2.test(grid: Array<IntArray>, expected: Int) {
    val actual = uniquePathsWithObstacles(grid)
    assertEquals(expected, actual)
}
