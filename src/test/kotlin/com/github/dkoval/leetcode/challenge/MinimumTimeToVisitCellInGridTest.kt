package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumTimeToVisitCellInGrid.MinimumTimeToVisitCellInGridRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumTimeToVisitCellInGridTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1, 3, 2),
                    intArrayOf(5, 1, 2, 5),
                    intArrayOf(4, 3, 8, 6)
                ),
                7
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 2, 4),
                    intArrayOf(3, 2, 1),
                    intArrayOf(1, 0, 4)
                ),
                -1
            )
        )
    }

    @Nested
    inner class MinimumTimeToVisitCellInGridRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum time required in which you can visit the bottom-right cell of the matrix`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            MinimumTimeToVisitCellInGridRev1().test(grid, expected)
        }
    }
}

private fun MinimumTimeToVisitCellInGridRev1.test(grid: Array<IntArray>, expected: Int) {
    val actual = minimumTime(grid)
    assertEquals(expected, actual)
}
