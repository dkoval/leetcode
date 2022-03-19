package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaxSumOfRectangleNoLargerThanK.MaxSumOfRectangleNoLargerThanKBruteForceWithPrefixSum
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class MaxSumOfRectangleNoLargerThanKTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 1),
                    intArrayOf(0, -2, 3)
                ),
                2,
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 2, -1)
                ),
                3,
                3
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 2, -1)
                ),
                2,
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 2, -1)
                ),
                0,
                -1
            )
        )
    }

    @Nested
    inner class MaxSumOfRectangleNoLargerThanKBruteForceWithPrefixSumTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the max sum of a rectangle in the matrix such that its sum is no larger than k`(
            matrix: Array<IntArray>,
            k: Int,
            expected: Int
        ) {
            MaxSumOfRectangleNoLargerThanKBruteForceWithPrefixSum().test(matrix, k, expected)
        }
    }

    private fun MaxSumOfRectangleNoLargerThanK.test(matrix: Array<IntArray>, k: Int, expected: Int) {
        val actual = maxSumSubmatrix(matrix, k)
        assertEquals(expected, actual)
    }
}