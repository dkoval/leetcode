package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class KWeakestRowsInMatrixTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1, 0),
                    intArrayOf(1, 0, 0, 0, 0),
                    intArrayOf(1, 1, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1, 1)
                ),
                3,
                intArrayOf(2, 0, 3)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1),
                    intArrayOf(1, 0, 0, 0),
                    intArrayOf(1, 0, 0, 0)
                ),
                2,
                intArrayOf(0, 2)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest`(
        mat: Array<IntArray>,
        k: Int,
        expected: IntArray
    ) {
        val actual = KWeakestRowsInMatrix().kWeakestRows(mat, k)
        assertArrayEquals(expected, actual)
    }
}