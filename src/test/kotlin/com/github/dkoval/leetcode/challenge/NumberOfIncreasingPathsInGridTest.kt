package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfIncreasingPathsInGrid.NumberOfIncreasingPathsInGridRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfIncreasingPathsInGridTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(3, 4)
                ),
                8
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1),
                    intArrayOf(2)
                ),
                3
            )
        )
    }

    @Nested
    inner class NumberOfIncreasingPathsInGridRev1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of strictly increasing paths in the grid such that you can start from any cell and end at any cell`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            NumberOfIncreasingPathsInGridRev1().test(grid, expected)
        }
    }
}

private fun NumberOfIncreasingPathsInGrid.test(grid: Array<IntArray>, expected: Int) {
    val actual = countPaths(grid)
    assertEquals(expected, actual)
}
