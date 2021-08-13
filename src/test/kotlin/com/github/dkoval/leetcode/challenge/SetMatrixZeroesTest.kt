package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SetMatrixZeroesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 0, 1),
                    intArrayOf(1, 1, 1)
                ),
                arrayOf(
                    intArrayOf(1, 0, 1),
                    intArrayOf(0, 0, 0),
                    intArrayOf(1, 0, 1)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1, 2, 0),
                    intArrayOf(3, 4, 5, 2),
                    intArrayOf(1, 3, 1, 5)
                ),
                arrayOf(
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(0, 4, 5, 0),
                    intArrayOf(0, 3, 1, 0)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(5, 0, 7, 8),
                    intArrayOf(0, 10, 11, 12),
                    intArrayOf(13, 14, 15, 0)
                ),
                arrayOf(
                    intArrayOf(0, 0, 3, 0),
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 3)
                ),
                arrayOf(
                    intArrayOf(0, 0, 0)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(-4, -2147483648, 6, -7, 0),
                    intArrayOf(-8, 6, -8, -6, 0),
                    intArrayOf(2147483647, 2, -9, -6, -10)
                ),
                arrayOf(
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(2147483647, 2, -9, -6, 0)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `if an element is 0, should set its entire row and column to 0's in place`(
        matrix: Array<IntArray>,
        expected: Array<IntArray>
    ) {
        SetMatrixZeroes().setZeroes(matrix)
        assertArrayEquals(expected, matrix)
    }
}