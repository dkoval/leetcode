package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class NumberOfSubmatricesThatSumToTargetTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1, 0),
                    intArrayOf(1, 1, 1),
                    intArrayOf(0, 1, 0)
                ),
                0,
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, -1),
                    intArrayOf(-1, 1)
                ),
                0,
                5
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(904)
                ),
                0,
                0
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the number of non-empty submatrices that sum to target`(
        matrix: Array<IntArray>,
        target: Int,
        expected: Int
    ) {
        val actual = NumberOfSubmatricesThatSumToTarget().numSubmatrixSumTarget(matrix, target)
        assertEquals(expected, actual)
    }
}