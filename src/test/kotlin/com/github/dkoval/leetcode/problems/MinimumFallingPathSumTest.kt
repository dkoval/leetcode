package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MinimumFallingPathSumTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
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

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the minimum sum of any falling path through matrix`(matrix: Array<IntArray>, expected: Int) {
        val actual = MinimumFallingPathSum().minFallingPathSum(matrix)
        assertEquals(expected, actual)
    }
}