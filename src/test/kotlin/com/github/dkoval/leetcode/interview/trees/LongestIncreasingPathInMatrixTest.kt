package com.github.dkoval.leetcode.interview.trees

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LongestIncreasingPathInMatrixTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(9, 9, 4),
                    intArrayOf(6, 6, 8),
                    intArrayOf(2, 1, 1)
                ),
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 4, 5),
                    intArrayOf(3, 2, 6),
                    intArrayOf(2, 2, 1)
                ),
                4
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the length of the longest increasing path in a matrix`(matrix: Array<IntArray>, expected: Int) {
        val actual = LongestIncreasingPathInMatrix().longestIncreasingPath(matrix)
        assertEquals(expected, actual)
    }
}