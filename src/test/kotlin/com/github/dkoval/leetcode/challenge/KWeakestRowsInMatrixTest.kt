package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.KWeakestRowsInMatrix.KWeakestRowsInMatrixBySortingRows
import com.github.dkoval.leetcode.challenge.KWeakestRowsInMatrix.KWeakestRowsInMatrixUsingPriorityQueue
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class KWeakestRowsInMatrixTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1, 0),
                    intArrayOf(1, 0, 0, 0, 0),
                    intArrayOf(1, 1, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1, 1)
                ),
                3,
                intArrayOf(2, 0, 3)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1),
                    intArrayOf(1, 0, 0, 0),
                    intArrayOf(1, 0, 0, 0)
                ),
                2,
                intArrayOf(0, 2)
            )
        )
    }

    @Nested
    inner class KWeakestRowsInMatrixUsingPriorityQueueTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest`(
            mat: Array<IntArray>,
            k: Int,
            expected: IntArray
        ) {
            KWeakestRowsInMatrixUsingPriorityQueue().test(mat, k, expected)
        }
    }

    @Nested
    inner class KWeakestRowsInMatrixBySortingRowsTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest`(
            mat: Array<IntArray>,
            k: Int,
            expected: IntArray
        ) {
            KWeakestRowsInMatrixBySortingRows().test(mat, k, expected)
        }
    }
}

private fun KWeakestRowsInMatrix.test(mat: Array<IntArray>, k: Int, expected: IntArray) {
    val actual = kWeakestRows(mat, k)
    assertArrayEquals(expected, actual)
}
