package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SpiralMatrix.SpiralMatrixRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SpiralMatrixTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9),
                ),
                listOf(1, 2, 3, 6, 9, 8, 7, 4, 5)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(5, 6, 7, 8),
                    intArrayOf(9, 10, 11, 12)
                ),
                listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)
            )
        )
    }

    @Nested
    inner class SpiralMatrixRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all elements of the matrix in spiral order`(matrix: Array<IntArray>, expected: List<Int>) {
            SpiralMatrixRev1().test(matrix, expected)

        }
    }
}

private fun SpiralMatrix.test(matrix: Array<IntArray>, expected: List<Int>) {
    val actual = spiralOrder(matrix)
    assertEquals(expected, actual)
}
