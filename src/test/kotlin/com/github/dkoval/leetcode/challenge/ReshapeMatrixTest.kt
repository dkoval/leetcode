package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class ReshapeMatrixTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 4)
                ),
                1,
                4,
                arrayOf(
                    intArrayOf(1, 2, 3, 4)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 4)
                ),
                2,
                4,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 4)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6)
                ),
                3,
                2,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 4),
                    intArrayOf(5, 6)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should reshape the original matrix`(matrix: Array<IntArray>, r: Int, c: Int, expected: Array<IntArray>) {
        val actual = ReshapeMatrix().matrixReshape(matrix, r, c)
        assertArrayEquals(expected, actual)
    }
}