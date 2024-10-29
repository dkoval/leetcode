package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumNumberOfMovesInGrid.MaximumNumberOfMovesInGridRev1
import com.github.dkoval.leetcode.challenge.MaximumNumberOfMovesInGrid.MaximumNumberOfMovesInGridRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumNumberOfMovesInGridTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 4, 3, 5),
                    intArrayOf(5, 4, 9, 3),
                    intArrayOf(3, 4, 2, 11),
                    intArrayOf(10, 9, 13, 15)
                ),
                3
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 2, 4),
                    intArrayOf(2, 1, 9),
                    intArrayOf(1, 1, 7),
                ),
                0
            )
        )
    }

    @Nested
    inner class MaximumNumberOfMovesInGridRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of moves that you can perform`(grid: Array<IntArray>, expected: Int) {
            MaximumNumberOfMovesInGridRev1().test(grid, expected)
        }
    }

    @Nested
    inner class MaximumNumberOfMovesInGridRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of moves that you can perform`(grid: Array<IntArray>, expected: Int) {
            MaximumNumberOfMovesInGridRev2().test(grid, expected)
        }
    }
}

private fun MaximumNumberOfMovesInGrid.test(grid: Array<IntArray>, expected: Int) {
    val actual = maxMoves(grid)
    assertEquals(expected, actual)
}
