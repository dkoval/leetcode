package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MatrixBlockSumTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9)
                ),
                1,
                arrayOf(
                    intArrayOf(12, 21, 16),
                    intArrayOf(27, 45, 33),
                    intArrayOf(24, 39, 28)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9)
                ),
                2,
                arrayOf(
                    intArrayOf(45, 45, 45),
                    intArrayOf(45, 45, 45),
                    intArrayOf(45, 45, 45)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return a matrix answer`(mat: Array<IntArray>, k: Int, expected: Array<IntArray>) {
        val actual = MatrixBlockSum().matrixBlockSum(mat, k)
        assertArrayEquals(expected, actual)
    }
}