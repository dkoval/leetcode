package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumAbsoluteDifferenceInSlidingSubmatrix.MinimumAbsoluteDifferenceInSlidingSubmatrixRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class MinimumAbsoluteDifferenceInSlidingSubmatrixTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 8),
                    intArrayOf(3, -2)
                ),
                2,
                arrayOf(
                    intArrayOf(2)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(3, -1)
                ),
                1,
                arrayOf(
                    intArrayOf(0, 0)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, -2, 3),
                    intArrayOf(2, 3, 5)
                ),
                2,
                arrayOf(
                    intArrayOf(1, 2)
                )
            )
        )
    }

    @Nested
    inner class MinimumAbsoluteDifferenceInSlidingSubmatrixRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum absolute differences between any two distinct elements in the k x k submatrix of mat with the top-left corner at (i, j)`(
            grid: Array<IntArray>,
            k: Int,
            expected: Array<IntArray>
        ) {
            MinimumAbsoluteDifferenceInSlidingSubmatrixRev1().test(grid, k, expected)
        }
    }
}

private fun MinimumAbsoluteDifferenceInSlidingSubmatrix.test(grid: Array<IntArray>, k: Int, expected: Array<IntArray>) {
    val actual = minAbsDiff(grid, k)
    assertArrayEquals(expected, actual)
}
