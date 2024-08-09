package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MagicSquaresInGrid.MagicSquaresInGridRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MagicSquaresInGridTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(4, 3, 8, 4),
                    intArrayOf(9, 5, 1, 9),
                    intArrayOf(2, 7, 6, 2)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(8)
                ),
                0
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(5, 5, 5),
                    intArrayOf(5, 5, 5),
                    intArrayOf(5, 5, 5)
                ),
                0
            )
        )
    }

    @Nested
    inner class MagicSquaresInGridRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return how many 3 x 3 contiguous magic square subgrids are there`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            MagicSquaresInGridRev1().test(grid, expected)
        }
    }
}

private fun MagicSquaresInGrid.test(grid: Array<IntArray>, expected: Int) {
    val actual = numMagicSquaresInside(grid)
    assertEquals(expected, actual)
}
