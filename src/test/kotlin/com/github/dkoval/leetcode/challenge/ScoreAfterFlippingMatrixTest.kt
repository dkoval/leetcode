package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ScoreAfterFlippingMatrix.ScoreAfterFlippingMatrixRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ScoreAfterFlippingMatrixTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 1, 1),
                    intArrayOf(1, 0, 1, 0),
                    intArrayOf(1, 1, 0, 0)
                ),
                39
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
    inner class ScoreAfterFlippingMatrixRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the highest possible score after making any number of moves`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            ScoreAfterFlippingMatrixRev1().test(grid, expected)
        }
    }
}

private fun ScoreAfterFlippingMatrix.test(grid: Array<IntArray>, expected: Int) {
    val actual = matrixScore(grid)
    assertEquals(expected, actual)
}
