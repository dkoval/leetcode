package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.MinimumFallingPathSum.MinimumFallingPathSumDPBottomUp
import com.github.dkoval.leetcode.problems.MinimumFallingPathSum.MinimumFallingPathSumDpTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumFallingPathSumTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 1, 3),
                    intArrayOf(6, 5, 4),
                    intArrayOf(7, 8, 9)
                ),
                13
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(-19, 57),
                    intArrayOf(-40, -5)
                ),
                -59
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(-48)
                ),
                -48
            )
        )
    }

    @Nested
    inner class MinimumFallingPathSumDpTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum sum of any falling path through matrix`(matrix: Array<IntArray>, expected: Int) {
            MinimumFallingPathSumDpTopDown().test(matrix, expected)
        }
    }

    @Nested
    inner class MinimumFallingPathSumDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum sum of any falling path through matrix`(matrix: Array<IntArray>, expected: Int) {
            MinimumFallingPathSumDPBottomUp().test(matrix, expected)
        }
    }

    private fun MinimumFallingPathSum.test(matrix: Array<IntArray>, expected: Int) {
        val actual = minFallingPathSum(matrix)
        assertEquals(expected, actual)
    }
}