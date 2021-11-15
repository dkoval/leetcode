package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SearchIn2DMatrix.SearchIn2DMatrixUsingBinarySearchWith2DCoordinatesRemapping
import com.github.dkoval.leetcode.challenge.SearchIn2DMatrix.SearchIn2DMatrixWithTwoBinarySearches
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SearchIn2DMatrixTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
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
    inner class SearchIn2DMatrixWithTwoBinarySearchesTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should search for a value in m x n matrix`(matrix: Array<IntArray>, target: Int, expected: Boolean) {
            SearchIn2DMatrixWithTwoBinarySearches().test(matrix, target, expected)
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

    private fun SearchIn2DMatrix.test(matrix: Array<IntArray>, target: Int, expected: Boolean) {
        val actual = searchMatrix(matrix, target)
        assertEquals(expected, actual)
    }
}