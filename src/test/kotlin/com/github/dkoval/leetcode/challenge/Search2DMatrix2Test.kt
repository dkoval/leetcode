package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.Search2DMatrix2.Search2DMatrix2Optimal
import com.github.dkoval.leetcode.challenge.Search2DMatrix2.Search2DMatrix2UsingBinarySearchWhenSearchingRows
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class Search2DMatrix2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 4, 7, 11, 15),
                    intArrayOf(2, 5, 8, 12, 19),
                    intArrayOf(3, 6, 9, 16, 22),
                    intArrayOf(10, 13, 14, 17, 24),
                    intArrayOf(18, 21, 23, 26, 30)
                ),
                5,
                true
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 4, 7, 11, 15),
                    intArrayOf(2, 5, 8, 12, 19),
                    intArrayOf(3, 6, 9, 16, 22),
                    intArrayOf(10, 13, 14, 17, 24),
                    intArrayOf(18, 21, 23, 26, 30)
                ),
                20,
                false
            )
        )
    }

    @Nested
    inner class Search2DMatrix2UsingBinarySearchWhenSearchingRowsTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should efficiently search for a target value in 2D matrix`(
            matrix: Array<IntArray>,
            target: Int,
            expected: Boolean
        ) {
            Search2DMatrix2UsingBinarySearchWhenSearchingRows().test(matrix, target, expected)
        }
    }

    @Nested
    inner class Search2DMatrix2OptimalTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should efficiently search for a target value in 2D matrix`(
            matrix: Array<IntArray>,
            target: Int,
            expected: Boolean
        ) {
            Search2DMatrix2Optimal().test(matrix, target, expected)
        }
    }

    private fun Search2DMatrix2.test(
        matrix: Array<IntArray>,
        target: Int,
        expected: Boolean
    ) {
        val actual = searchMatrix(matrix, target)
        assertEquals(expected, actual)
    }
}