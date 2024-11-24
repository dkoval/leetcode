package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumMatrixSum.MaximumMatrixSumRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumMatrixSumTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, -1),
                    intArrayOf(-1, 1)
                ),
                4L
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(-1, -2, -3),
                    intArrayOf(1, 2, 3)
                ),
                16L
            )
        )
    }

    @Nested
    inner class MaximumMatrixSumRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum sum of the matrix's elements using the operation`(
            matrix: Array<IntArray>,
            expected: Long
        ) {
            MaximumMatrixSumRev1().test(matrix, expected)
        }
    }
}

private fun MaximumMatrixSum.test(matrix: Array<IntArray>, expected: Long) {
    val actual = maxMatrixSum(matrix)
    assertEquals(expected, actual)
}
