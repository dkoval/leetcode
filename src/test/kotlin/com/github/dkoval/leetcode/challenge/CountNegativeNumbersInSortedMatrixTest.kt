package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountNegativeNumbersInSortedMatrix.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountNegativeNumbersInSortedMatrixTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(4, 3, 2, -1),
                    intArrayOf(3, 2, 1, -1),
                    intArrayOf(1, 1, -1, -2),
                    intArrayOf(-1, -1, -2, -3)
                ),
                8
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 2),
                    intArrayOf(1, 0)
                ),
                0
            )
        )
    }

    @Nested
    inner class CountNegativeNumbersInSortedMatrixRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of negative numbers in grid`(grid: Array<IntArray>, expected: Int) {
            CountNegativeNumbersInSortedMatrixRev1().test(grid, expected)
        }
    }

    @Nested
    inner class CountNegativeNumbersInSortedMatrixRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of negative numbers in grid`(grid: Array<IntArray>, expected: Int) {
            CountNegativeNumbersInSortedMatrixRev2().test(grid, expected)
        }
    }

    @Nested
    inner class CountNegativeNumbersInSortedMatrixRev3Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of negative numbers in grid`(grid: Array<IntArray>, expected: Int) {
            CountNegativeNumbersInSortedMatrixRev3().test(grid, expected)
        }
    }
}

private fun CountNegativeNumbersInSortedMatrix.test(grid: Array<IntArray>, expected: Int) {
    val actual = countNegatives(grid)
    assertEquals(expected, actual)
}
