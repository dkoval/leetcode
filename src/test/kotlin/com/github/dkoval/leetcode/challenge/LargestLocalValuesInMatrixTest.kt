package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LargestLocalValuesInMatrix.LargestLocalValuesInMatrixRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LargestLocalValuesInMatrixTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(9, 9, 8, 1),
                    intArrayOf(5, 6, 2, 6),
                    intArrayOf(8, 2, 6, 4),
                    intArrayOf(6, 2, 2, 2)
                ),
                arrayOf(
                    intArrayOf(9, 9),
                    intArrayOf(8, 6)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1, 1, 1, 1),
                    intArrayOf(1, 1, 1, 1, 1),
                    intArrayOf(1, 1, 2, 1, 1),
                    intArrayOf(1, 1, 1, 1, 1),
                    intArrayOf(1, 1, 1, 1, 1)
                ),
                arrayOf(
                    intArrayOf(2, 2, 2),
                    intArrayOf(2, 2, 2),
                    intArrayOf(2, 2, 2)
                )
            )
        )
    }

    @Nested
    inner class LargestLocalValuesInMatrixRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should we find the largest value in every contiguous 3 x 3 matrix in grid`(
            grid: Array<IntArray>,
            expected: Array<IntArray>
        ) {
            LargestLocalValuesInMatrixRev1().test(grid, expected)
        }
    }
}

private fun LargestLocalValuesInMatrix.test(grid: Array<IntArray>, expected: Array<IntArray>) {
    val actual = largestLocal(grid)
    assertArrayEquals(expected, actual)
}
