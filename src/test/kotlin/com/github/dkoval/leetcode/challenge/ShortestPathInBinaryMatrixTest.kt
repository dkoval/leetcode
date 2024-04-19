package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ShortestPathInBinaryMatrix.ShortestPathInBinaryMatrixRev1
import com.github.dkoval.leetcode.challenge.ShortestPathInBinaryMatrix.ShortestPathInBinaryMatrixRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ShortestPathInBinaryMatrixTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 0)
                ),
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(1, 1, 0),
                    intArrayOf(1, 1, 0)
                ),
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 0)
                ),
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 0),
                    intArrayOf(1, 1, 0),
                    intArrayOf(1, 1, 0)
                ),
                -1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0)
                ),
                1
            )
        )
    }

    @Nested
    inner class ShortestPathInBinaryMatrixRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the shortest such clear path from top-left to bottom-right`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            ShortestPathInBinaryMatrixRev1().test(grid, expected)
        }
    }

    @Nested
    inner class ShortestPathInBinaryMatrixRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the shortest such clear path from top-left to bottom-right`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            ShortestPathInBinaryMatrixRev2().test(grid, expected)
        }
    }
}

private fun ShortestPathInBinaryMatrix.test(grid: Array<IntArray>, expected: Int) {
    val actual = shortestPathBinaryMatrix(grid)
    assertEquals(expected, actual)
}
