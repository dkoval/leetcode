package com.github.dkoval.leetcode.interview.array

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SetMatrixZeroesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 0, 1),
                    intArrayOf(1, 1, 1)
                ),
                arrayOf(
                    intArrayOf(1, 0, 1),
                    intArrayOf(0, 0, 0),
                    intArrayOf(1, 0, 1)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1, 2, 0),
                    intArrayOf(3, 4, 5, 2),
                    intArrayOf(1, 3, 1, 5),
                ),
                arrayOf(
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(0, 4, 5, 0),
                    intArrayOf(0, 3, 1, 0)
                )
            )
        )
    }

    @Nested
    inner class SetMatrixZeroesUsingExtraSpaceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should set matrix zeros`(matrix: Array<IntArray>, expected: Array<IntArray>) {
            SetMatrixZeroesUsingExtraSpace.test(matrix, expected)
        }
    }

    @Nested
    inner class SetMatrixZeroesConstantSpaceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should set matrix zeros`(matrix: Array<IntArray>, expected: Array<IntArray>) {
            SetMatrixZeroesConstantSpace.test(matrix, expected)
        }
    }

    private fun SetMatrixZeroes.test(matrix: Array<IntArray>, expected: Array<IntArray>) {
        setZeroes(matrix)
        assertArrayEquals(expected, matrix)
    }
}