package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfSubmatricesThatSumToTarget.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfSubmatricesThatSumToTargetTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1, 0),
                    intArrayOf(1, 1, 1),
                    intArrayOf(0, 1, 0)
                ),
                0,
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, -1),
                    intArrayOf(-1, 1)
                ),
                0,
                5
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(904)
                ),
                0,
                0
            )
        )
    }

    @Nested
    inner class NumberOfSubmatricesThatSumToTargetRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of non-empty submatrices that sum to target`(
            matrix: Array<IntArray>,
            target: Int,
            expected: Int
        ) {
            NumberOfSubmatricesThatSumToTargetRev1().test(matrix, target, expected)
        }
    }

    @Nested
    inner class NumberOfSubmatricesThatSumToTargetRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of non-empty submatrices that sum to target`(
            matrix: Array<IntArray>,
            target: Int,
            expected: Int
        ) {
            NumberOfSubmatricesThatSumToTargetRev2().test(matrix, target, expected)
        }
    }

    @Nested
    inner class NumberOfSubmatricesThatSumToTargetRev3Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of non-empty submatrices that sum to target`(
            matrix: Array<IntArray>,
            target: Int,
            expected: Int
        ) {
            NumberOfSubmatricesThatSumToTargetRev3().test(matrix, target, expected)
        }
    }

    private fun NumberOfSubmatricesThatSumToTarget.test(matrix: Array<IntArray>, target: Int, expected: Int) {
        val actual = numSubmatrixSumTarget(matrix, target)
        assertEquals(expected, actual)
    }
}