package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.KthSmallestElementInSortedMatrix.KthSmallestElementInSortedMatrixUsingBinarySearch
import com.github.dkoval.leetcode.challenge.KthSmallestElementInSortedMatrix.KthSmallestElementInSortedMatrixUsingMaxHeap
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class KthSmallestElementInSortedMatrixTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 5, 9),
                    intArrayOf(10, 11, 13),
                    intArrayOf(12, 13, 15)
                ),
                8,
                13
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(-5)
                ),
                1,
                -5
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(1, 3)
                ),
                2,
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(1, 3)
                ),
                3,
                2
            )
        )
    }

    @Nested
    inner class KthSmallestElementInSortedMatrixUsingMaxHeapTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return kth smallest element in a sorted matrix`(matrix: Array<IntArray>, k: Int, expected: Int) {
            KthSmallestElementInSortedMatrixUsingMaxHeap().test(matrix, k, expected)
        }
    }

    @Nested
    inner class KthSmallestElementInSortedMatrixUsingBinarySearchTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return kth smallest element in a sorted matrix`(matrix: Array<IntArray>, k: Int, expected: Int) {
            KthSmallestElementInSortedMatrixUsingBinarySearch().test(matrix, k, expected)
        }
    }

    private fun KthSmallestElementInSortedMatrix.test(matrix: Array<IntArray>, k: Int, expected: Int) {
        val actual = kthSmallest(matrix, k)
        assertEquals(expected, actual)
    }
}