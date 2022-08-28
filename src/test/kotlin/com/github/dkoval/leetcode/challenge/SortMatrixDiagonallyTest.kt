package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SortMatrixDiagonally.SortMatrixDiagonallyRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SortMatrixDiagonallyTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 3, 1, 1),
                    intArrayOf(2, 2, 1, 2),
                    intArrayOf(1, 1, 1, 2)
                ),
                arrayOf(
                    intArrayOf(1, 1, 1, 1),
                    intArrayOf(1, 2, 2, 2),
                    intArrayOf(1, 2, 3, 3)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(11, 25, 66, 1, 69, 7),
                    intArrayOf(23, 55, 17, 45, 15, 52),
                    intArrayOf(75, 31, 36, 44, 58, 8),
                    intArrayOf(22, 27, 33, 25, 68, 4),
                    intArrayOf(84, 28, 14, 11, 5, 50)
                ),
                arrayOf(
                    intArrayOf(5, 17, 4, 1, 52, 7),
                    intArrayOf(11, 11, 25, 45, 8, 69),
                    intArrayOf(14, 23, 25, 44, 58, 15),
                    intArrayOf(22, 27, 31, 36, 50, 66),
                    intArrayOf(84, 28, 75, 33, 55, 68)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1)
                ),
                arrayOf(
                    intArrayOf(1)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 2, 1)
                ),
                arrayOf(
                    intArrayOf(3, 2, 1)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(3),
                    intArrayOf(2),
                    intArrayOf(1),
                ),
                arrayOf(
                    intArrayOf(3),
                    intArrayOf(2),
                    intArrayOf(1),
                )
            )
        )
    }

    @Nested
    inner class SortMatrixDiagonallyRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should sort each matrix diagonal in ascending order and return the resulting matrix`(
            mat: Array<IntArray>,
            expected: Array<IntArray>
        ) {
            SortMatrixDiagonallyRev1().test(mat, expected)
        }
    }

    fun SortMatrixDiagonally.test(mat: Array<IntArray>, expected: Array<IntArray>) {
        val actual = diagonalSort(mat)
        assertThat(actual).containsExactly(*expected)
    }
}