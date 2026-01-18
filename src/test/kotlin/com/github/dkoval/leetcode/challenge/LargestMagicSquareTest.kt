package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LargestMagicSquare.LargestMagicSquareRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LargestMagicSquareTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(7, 1, 4, 5, 6),
                    intArrayOf(2, 5, 1, 6, 4),
                    intArrayOf(1, 5, 4, 3, 2),
                    intArrayOf(1, 2, 7, 3, 4)
                ),
                3
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(5, 1, 3, 1),
                    intArrayOf(9, 3, 3, 1),
                    intArrayOf(1, 3, 3, 8)
                ),
                2
            )
        )
    }

    @Nested
    inner class LargestMagicSquareRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the size of the largest magic square that can be found within this grid`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            LargestMagicSquareRev1().test(grid, expected)
        }
    }
}

private fun LargestMagicSquare.test(grid: Array<IntArray>, expected: Int) {
    val actual = largestMagicSquare(grid)
    assertEquals(expected, actual)
}
