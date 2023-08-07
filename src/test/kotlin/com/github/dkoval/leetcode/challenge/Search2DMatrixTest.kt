package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.Search2DMatrix.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class Search2DMatrixTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 3, 5, 7),
                    intArrayOf(10, 11, 16, 20),
                    intArrayOf(23, 30, 34, 60)
                ),
                3,
                true
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 3, 5, 7),
                    intArrayOf(10, 11, 16, 20),
                    intArrayOf(23, 30, 34, 60)
                ),
                13,
                false
            )
        )
    }

    @Nested
    inner class Search2DMatrixWithTwoBinarySearchesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should search for a value in m x n matrix`(matrix: Array<IntArray>, target: Int, expected: Boolean) {
            Search2DMatrixWithTwoBinarySearchesRev1().test(matrix, target, expected)
        }
    }

    @Nested
    inner class Search2DMatrixWithTwoBinarySearchesRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should search for a value in m x n matrix`(matrix: Array<IntArray>, target: Int, expected: Boolean) {
            Search2DMatrixWithTwoBinarySearchesRev2().test(matrix, target, expected)
        }
    }

    @Nested
    inner class SearchIn2DMatrixUsingBinarySearchWith2DCoordinatesRemappingTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should search for a value in m x n matrix`(matrix: Array<IntArray>, target: Int, expected: Boolean) {
            SearchIn2DMatrixUsingBinarySearchWith2DCoordinatesRemapping().test(matrix, target, expected)
        }
    }
}

private fun Search2DMatrix.test(matrix: Array<IntArray>, target: Int, expected: Boolean) {
    val actual = searchMatrix(matrix, target)
    assertEquals(expected, actual)
}
