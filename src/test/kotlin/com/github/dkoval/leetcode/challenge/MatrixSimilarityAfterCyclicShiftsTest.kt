package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MatrixSimilarityAfterCyclicShifts.MatrixSimilarityAfterCyclicShiftsRev1
import com.github.dkoval.leetcode.challenge.MatrixSimilarityAfterCyclicShifts.MatrixSimilarityAfterCyclicShiftsRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class MatrixSimilarityAfterCyclicShiftsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9)
                ),
                4,
                false
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 1, 2),
                    intArrayOf(5, 5, 5, 5),
                    intArrayOf(6, 3, 6, 3)
                ),
                2,
                true
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 2),
                    intArrayOf(2, 2)
                ),
                3,
                true
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(7, 7),
                    intArrayOf(10, 10),
                    intArrayOf(4, 4)
                ),
                2,
                true
            )
        )
    }

    @Nested
    inner class MatrixSimilarityAfterCyclicShiftsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if the final modified matrix after k steps is identical to the original matrix`(
            matrix: Array<IntArray>,
            k: Int,
            expected: Boolean
        ) {
            MatrixSimilarityAfterCyclicShiftsRev1().test(matrix, k, expected)
        }
    }

    @Nested
    inner class MatrixSimilarityAfterCyclicShiftsRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if the final modified matrix after k steps is identical to the original matrix`(
            matrix: Array<IntArray>,
            k: Int,
            expected: Boolean
        ) {
            MatrixSimilarityAfterCyclicShiftsRev2().test(matrix, k, expected)
        }
    }
}

private fun MatrixSimilarityAfterCyclicShifts.test(matrix: Array<IntArray>, k: Int, expected: Boolean) {
    val actual = areSimilar(matrix, k)
    assertEquals(expected, actual)
}
