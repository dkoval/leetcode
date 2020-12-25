package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class DiagonalTraverseTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9)
                ),
                intArrayOf(1, 2, 4, 7, 5, 3, 6, 8, 9)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return all elements of the matrix in diagonal order`(matrix: Array<IntArray>, expected: IntArray) {
        val actual = DiagonalTraverse().findDiagonalOrder(matrix)
        assertArrayEquals(expected, actual)
    }
}