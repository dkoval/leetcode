package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ZeroOneMatrixTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 0)
                ),
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 0)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(1, 1, 1)
                ),
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(1, 2, 1)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the distance of the nearest 0 for each cell`(mat: Array<IntArray>, expected: Array<IntArray>) {
        val actual = ZeroOneMatrix().updateMatrix(mat)
        assertArrayEquals(expected, actual)
    }
}