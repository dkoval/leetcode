package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MatrixDiagonalSum.MatrixDiagonalSumRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MatrixDiagonalSumTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9)
                ),
                25
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1, 1, 1),
                    intArrayOf(1, 1, 1, 1),
                    intArrayOf(1, 1, 1, 1),
                    intArrayOf(1, 1, 1, 1)
                ),
                8
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(5)
                ),
                5
            )
        )
    }

    @Nested
    inner class MatrixDiagonalSumRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal`(
            mat: Array<IntArray>,
            expected: Int
        ) {
            MatrixDiagonalSumRev1().test(mat, expected)
        }
    }
}

private fun MatrixDiagonalSum.test(mat: Array<IntArray>, expected: Int) {
    val actual = diagonalSum(mat)
    assertEquals(expected, actual)
}
