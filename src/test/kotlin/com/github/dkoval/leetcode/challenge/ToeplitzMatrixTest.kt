package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ToeplitzMatrix.ToeplitzMatrixRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ToeplitzMatrixTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(5, 1, 2, 3),
                    intArrayOf(9, 5, 1, 2),
                ),
                true
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 2)
                ),
                false
            )
        )
    }

    @Nested
    inner class ToeplitzMatrixRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if the matrix is Toeplitz`(matrix: Array<IntArray>, expected: Boolean) {
            ToeplitzMatrixRev1().test(matrix, expected)
        }
    }

    private fun ToeplitzMatrix.test(matrix: Array<IntArray>, expected: Boolean) {
        val actual = isToeplitzMatrix(matrix)
        assertEquals(expected, actual)
    }
}