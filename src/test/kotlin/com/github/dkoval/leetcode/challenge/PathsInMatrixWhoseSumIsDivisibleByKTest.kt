package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PathsInMatrixWhoseSumIsDivisibleByK.PathsInMatrixWhoseSumIsDivisibleByRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PathsInMatrixWhoseSumIsDivisibleByKTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(5, 2, 4),
                    intArrayOf(3, 0, 5),
                    intArrayOf(0, 7, 2)
                ),
                3,
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0)
                ),
                5,
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(7, 3, 4, 9),
                    intArrayOf(2, 3, 6, 2),
                    intArrayOf(2, 3, 7, 0)
                ),
                1,
                10
            )
        )
    }

    @Nested
    inner class PathsInMatrixWhoseSumIsDivisibleByKRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of paths from the top-left to the bottom-right cell such that the sum of the values along the path is divisible by k`(
            grid: Array<IntArray>,
            k: Int,
            expected: Int
        ) {
            PathsInMatrixWhoseSumIsDivisibleByRev1().test(grid, k, expected)
        }
    }
}

private fun PathsInMatrixWhoseSumIsDivisibleByK.test(grid: Array<IntArray>, k: Int, expected: Int) {
    val actual = numberOfPaths(grid, k)
    assertEquals(expected, actual)
}
