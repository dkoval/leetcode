package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FlipSquareSubmatrixVertically.FlipSquareSubmatrixVerticallyRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class FlipSquareSubmatrixVerticallyTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(5, 6, 7, 8),
                    intArrayOf(9, 10, 11, 12),
                    intArrayOf(13, 14, 15, 16)
                ),
                1, 0, 3,
                arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(13, 14, 15, 8),
                    intArrayOf(9, 10, 11, 12),
                    intArrayOf(5, 6, 7, 16)
                )
            ),
            arguments(
                arrayOf(
                    intArrayOf(3, 4, 2, 3),
                    intArrayOf(2, 3, 4, 2)
                ),
                0, 2, 2,
                arrayOf(
                    intArrayOf(3, 4, 4, 2),
                    intArrayOf(2, 3, 2, 3)
                )
            )
        )
    }

    @Nested
    inner class FlipSquareSubmatrixVerticallyRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should lip the submatrix by reversing the order of its rows vertically`(
            grid: Array<IntArray>,
            x: Int,
            y: Int,
            k: Int,
            expected: Array<IntArray>
        ) {
            FlipSquareSubmatrixVerticallyRev1().test(grid, x, y, k, expected)
        }
    }
}

private fun FlipSquareSubmatrixVertically.test(
    grid: Array<IntArray>,
    x: Int,
    y: Int,
    k: Int,
    expected: Array<IntArray>
) {
    val actual = reverseSubmatrix(grid, x, y, k)
    assertArrayEquals(expected, actual)
}
