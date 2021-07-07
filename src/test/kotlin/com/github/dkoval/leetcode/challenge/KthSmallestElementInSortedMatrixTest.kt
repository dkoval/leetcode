package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class KthSmallestElementInSortedMatrixTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 5, 9),
                    intArrayOf(10, 11, 13),
                    intArrayOf(12, 13, 15)
                ),
                8,
                13
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(-5)
                ),
                1,
                -5
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(1, 3)
                ),
                2,
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(1, 3)
                ),
                3,
                2
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return kth smallest element in a sorted matrix`(matrix: Array<IntArray>, k: Int, expected: Int) {
        val actual = KthSmallestElementInSortedMatrix().kthSmallest(matrix, k)
        assertEquals(expected, actual)
    }
}