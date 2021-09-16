package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SpiralMatrixTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9),
                ),
                listOf(1, 2, 3, 6, 9, 8, 7, 4, 5)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(5, 6, 7, 8),
                    intArrayOf(9, 10, 11, 12)
                ),
                listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return all elements of the matrix in spiral order`(matrix: Array<IntArray>, expected: List<Int>) {
        val actual = SpiralMatrix().spiralOrder(matrix)
        assertEquals(expected, actual)
    }
}